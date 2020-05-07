package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.date.DateTime;
import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.ApplicationFormMapper;
import com.caler.zkl.openpsd.mapper.ApplicationProductMapper;
import com.caler.zkl.openpsd.mapper.SysDictMapper;
import com.caler.zkl.openpsd.service.ApplicationService;
import com.caler.zkl.openpsd.util.UserServiceUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
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

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    @Transactional
    public int create(Application application) {

        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            //申请数据
            int count = 0;
            ApplicationForm applicationForm = application.getApplicationForm();
            applicationForm.setApplyTime(new Date());
            applicationForm.setIsDelete(0);
            applicationForm.setApplyOn(applicationForm.getApplyOn() == null ? userServiceUtil.getUser().getId() : applicationForm.getApplyOn());
            count = applicationFormMapper.insertSelective(applicationForm);
            //流水号更新
            SysDict s = new SysDict();
            s.setId(4L);
            s.setDataValue(applicationForm.getFormCode().substring(applicationForm.getFormCode().lastIndexOf("-")+1));
            sysDictMapper.updateByPrimaryKeySelective(s);//更新流水号
            //添加明细
            List<ApplicationProduct> productList = application.getApplicationProducts();
            productList.forEach(item -> {
                item.setMainid(application.getApplicationForm().getId());
                item.setRecordTime(new Date());
                item.setIsDelete(0);
                item.setRecordOn(userServiceUtil.getUser().getId());
                applicationProductMapper.insertSelective(item);
            });
            return count;
        } finally {
            lock.unlock();
        }
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

    @Override
    @Transactional
    public String generateFormNo() {
        SysDictExample example = new SysDictExample();
        example.createCriteria().andDataTypeEqualTo("1");
        example.setOrderByClause("sort");
        List<SysDict> dicts = sysDictMapper.selectByExample(example);
        SysDictExample example1 = new SysDictExample();
        example1.createCriteria().andDataTypeEqualTo("2");
        example1.setOrderByClause("sort");
        List<SysDict> dictList = sysDictMapper.selectByExample(example1);

        ReentrantLock lock = new ReentrantLock();
        final StringBuilder formNo = new StringBuilder();
        dicts.forEach(item -> {
            try {
                lock.lock();
                String dataCode = item.getDataCode();
                String dataValue = item.getDataValue();

                if ("t1".equals(dataCode)) {
                    formNo.append(dataValue);
                }
                if ("t2".equals(dataCode)) {//年月
                    formNo.append("-");
                    SimpleDateFormat sdf = new SimpleDateFormat(dataValue);
                    String format = sdf.format(new Date());
                    formNo.append(format);
                }
                if ("t3".equals(dataCode)) {//流水号
                    formNo.append("-");
                    SysDict sysDict = dictList.get(0);
                    String no = String.format("%04d", Integer.parseInt(sysDict.getDataValue())+1);
                    formNo.append(no);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        return formNo.toString();
    }
}
