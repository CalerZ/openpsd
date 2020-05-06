package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.ApplicationFormMapper;
import com.caler.zkl.openpsd.mapper.ApplicationProductMapper;
import com.caler.zkl.openpsd.service.ApplicationService;
import com.caler.zkl.openpsd.util.UserServiceUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationFormMapper applicationFormMapper;
    @Autowired
    private ApplicationProductMapper applicationProductMapper;

    @Autowired
    private UserServiceUtil userServiceUtil;

    @Override
    @Transactional
    public int create(Application application) {
        int count = 0;
        ApplicationForm applicationForm = application.getApplicationForm();
        applicationForm.setApplyTime(new Date());
        applicationForm.setIsDelete(0);
        applicationForm.setApplyOn(applicationForm.getApplyOn() == null ? userServiceUtil.getUser().getId() : applicationForm.getApplyOn());
        count = applicationFormMapper.insertSelective(applicationForm);
        List<ApplicationProduct> productList = application.getApplicationProducts();
        productList.forEach(item -> {
            item.setMainid(application.getApplicationForm().getId());
            item.setRecordTime(new Date());
            item.setIsDelete(0);
            item.setRecordOn(userServiceUtil.getUser().getId());
            applicationProductMapper.insertSelective(item);
        });
        return count;
    }

    @Override
    @Transactional
    public int update(Application application) {
        int count = 0;
        ApplicationForm applicationForm = application.getApplicationForm();
        applicationForm.setModifyTime(new Date());
        applicationForm.setModifyOn(applicationForm.getModifyOn() == null ? userServiceUtil.getUser().getId() : applicationForm.getModifyOn());
        count = applicationFormMapper.updateByPrimaryKeySelective(applicationForm);

        ApplicationProductExample example = new ApplicationProductExample();
        example.createCriteria().andMainidEqualTo(application.getApplicationForm().getId());
        applicationProductMapper.deleteByExample(example);

        List<ApplicationProduct> productList = application.getApplicationProducts();
        productList.forEach(item -> {
            item.setMainid(application.getApplicationForm().getId());
            item.setRecordTime(new Date());
            item.setIsDelete(0);
            item.setRecordOn(userServiceUtil.getUser().getId());
            applicationProductMapper.insertSelective(item);
        });
        return count;
    }

    @Override
    @Transactional
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id : ids) {
            count += delete(id);
        }
        return count;
    }

    @Override
    @Transactional
    public int delete(Long id) {
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setId(id);
        applicationForm.setIsDelete(1);
        int count = applicationFormMapper.updateByPrimaryKeySelective(applicationForm);
        ApplicationProduct applicationProduct = new ApplicationProduct();
        applicationProduct.setIsDelete(1);
        ApplicationProductExample example = new ApplicationProductExample();
        example.createCriteria().andMainidEqualTo(id);
        applicationProductMapper.updateByExample(applicationProduct, example);
        return count;
    }

    @Override
    public Application list(Long id) {
        Application application = new Application();
        application.setApplicationForm(applicationFormMapper.selectByPrimaryKey(id));
        ApplicationProductExample example = new ApplicationProductExample();
        example.createCriteria().andMainidEqualTo(id);
        application.setApplicationProducts(applicationProductMapper.selectByExample(example));
        return application;
    }

    @Override
    public List<Application> list() {
        return applicationFormMapper.selectByExample(null).stream().map(item -> {
            Application application = new Application();
            application.setApplicationForm(item);
            return application;
        }).collect(Collectors.toList());

    }

    @Override
    public List<Application> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ApplicationFormExample example = new ApplicationFormExample();
        example.createCriteria().andIsDeleteEqualTo(0);
        return applicationFormMapper.selectByExample(example).stream().map(item -> {
            Application application = new Application();
            application.setApplicationForm(item);
            return application;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Application> myApplicationList(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ApplicationFormExample example = new ApplicationFormExample();
        example.createCriteria().andApplyOnEqualTo(userServiceUtil.getUser().getId()).andIsDeleteEqualTo(0);
        return applicationFormMapper.selectByExample(example).stream().map(item -> {
            Application application = new Application();
            application.setApplicationForm(item);
            return application;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Application> reviewedApplicationList(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ApplicationFormExample example = new ApplicationFormExample();
        example.createCriteria()
                .andApproverEqualTo(userServiceUtil.getUser().getId())
                .andApplyStatusEqualTo(0)
                .andIsDeleteEqualTo(0)
                .andApplyOnNotEqualTo(userServiceUtil.getUser().getId());
        return applicationFormMapper.selectByExample(example).stream().map(item -> {
            Application application = new Application();
            application.setApplicationForm(item);
            return application;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public int submit(Application application) {
        application.getApplicationForm().setApplyStatus(1);
        return create(application);
    }
}
