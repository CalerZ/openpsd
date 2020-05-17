package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.ProductExcelData;
import com.caler.zkl.openpsd.mapper.ApplicationFormDao;
import com.caler.zkl.openpsd.mapper.ApplicationFormMapper;
import com.caler.zkl.openpsd.mapper.ApplicationProductMapper;
import com.caler.zkl.openpsd.mapper.SysDictMapper;
import com.caler.zkl.openpsd.service.ApplicationService;
import com.caler.zkl.openpsd.util.UserServiceUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
    @Autowired
    private ApplicationFormDao applicationFormDao;

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
            applicationForm.setApplyStatus(0);
            applicationForm.setApplyOn(applicationForm.getApplyOn() == null ? userServiceUtil.getUser().getId() : applicationForm.getApplyOn());
            count = applicationFormMapper.insertSelective(applicationForm);
            //流水号更新
            SysDict s = new SysDict();
            s.setId(4L);
            s.setDataValue(applicationForm.getFormCode().substring(applicationForm.getFormCode().lastIndexOf("-") + 1));
            sysDictMapper.updateByPrimaryKeySelective(s);//更新流水号
            //添加明细
            List<ApplicationProduct> productList = application.getApplicationProducts();
            productList.forEach(item -> {
                item.setMainid(application.getApplicationForm().getId());
                item.setRecordTime(new Date());
                item.setIsDelete(0);
                item.setStatus(0);
                item.setRecordOn(userServiceUtil.getUser().getId());
                applicationProductMapper.insertSelective(item);
            });
            return count;
        } finally {
            lock.unlock();
        }
    }

    private void copyProperties(ApplicationBean applicationBean, Application application) {

        BeanUtil.copyProperties(applicationBean.getApplicationForm(), application.getApplicationForm());
        BeanUtil.copyProperties(applicationBean.getApplicationProducts(), application.getApplicationProducts());
    }

    @Override
    @Transactional
    public int submit(Application application) {

        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            //申请数据
            int count = 0;
            ApplicationForm applicationForm = application.getApplicationForm();
            applicationForm.setApplyTime(new Date());
            applicationForm.setIsDelete(0);
            applicationForm.setApplyStatus(1);
            applicationForm.setApplyOn(applicationForm.getApplyOn() == null ? userServiceUtil.getUser().getId() : applicationForm.getApplyOn());
            count = applicationFormMapper.insertSelective(applicationForm);
            //流水号更新
            SysDict s = new SysDict();
            s.setId(4L);
            s.setDataValue(applicationForm.getFormCode().substring(applicationForm.getFormCode().lastIndexOf("-") + 1));
            sysDictMapper.updateByPrimaryKeySelective(s);//更新流水号
            //添加明细
            List<ApplicationProduct> productList = application.getApplicationProducts();
            productList.forEach(item -> {
                item.setMainid(application.getApplicationForm().getId());
                item.setRecordTime(new Date());
                item.setIsDelete(0);
                item.setStatus(1);
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
        applicationProductMapper.updateByExampleSelective(applicationProduct, example);
        return count;
    }

    @Override
    public ApplicationBean list(Long id) {
        ApplicationBean applicationBean = new ApplicationBean();
        ApplicationFormBean applicationFormBean = applicationFormDao.selectOneForm(id);
        List<ApplicationProductBean> applicationProductBeans = applicationFormDao.selectFormProduct(id);
        applicationBean.setApplicationForm(applicationFormBean);
        applicationBean.setApplicationProducts(applicationProductBeans);
        return applicationBean;
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
    public List<ApplicationFormBean> list(String keyword, Integer pageSize, Integer pageNum) {
        Long userid = userServiceUtil.getUser().getId();
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationFormBean> list = applicationFormDao.myApplicationList(keyword, null, userid);
        return list;
    }

    @Override
    public List<ApplicationFormBean> myApplicationList(String keyword, Integer pageSize, Integer pageNum) {

        Long userid = userServiceUtil.getUser().getId();
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationFormBean> list = applicationFormDao.myApplicationList(keyword, null, userid);
        return list;
    }

    public List<ApplicationFormBean> reviewedApplicationList(String keyword, Integer pageSize, Integer pageNum) {
        Long userid = userServiceUtil.getUser().getId();
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationFormBean> list = applicationFormDao.reviewedApplicationList(keyword, userid);
        return list;
    }

    @Override
    public List<ApplicationFormBean> finishApplicationList(String keyword, Integer pageSize, Integer pageNum) {
        Long userid = userServiceUtil.getUser().getId();
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationFormBean> list = applicationFormDao.finishApplicationList(keyword, userid);
        return list;
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
                    String no = String.format("%0" + item.getDataValue() + "d", Integer.parseInt(sysDict.getDataValue()) + 1);
                    formNo.append(no);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        return formNo.toString();
    }

    @Override
    public int updateStatus(List<Long> ids) {
        AtomicInteger count = new AtomicInteger();
        ids.forEach(item -> {
            ApplicationForm applicationForm = new ApplicationForm();
            applicationForm.setId(item);
            applicationForm.setApplyStatus(1);
            count.addAndGet(applicationFormMapper.updateByPrimaryKeySelective(applicationForm));
            ApplicationProductExample example = new ApplicationProductExample();
            example.createCriteria().andMainidEqualTo(item);
            List<ApplicationProduct> applicationProducts = applicationProductMapper.selectByExample(example);
            applicationProducts.stream().forEach(product -> {
                ApplicationProduct applicationProduct = new ApplicationProduct();
                applicationProduct.setId(product.getId());
                applicationProduct.setStatus(1);
                applicationProductMapper.updateByPrimaryKeySelective(applicationProduct);
            });

        });
        return count.get();
    }

    @Override
    public List<ProductExcelData> getExcelData(String[] dates, String quarter, String year) {
        SimpleDateFormat sdfa = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdfa.format(new Date());
        String[] years = new String[2];
        String[] quarters = new String[2];
        String dateStart = null;
        String dateEnd = null;
        String quarterStart = null;
        String quarterEnd = null;
        String yearStart = null;
        String yearEnd = null;
        String yearStr = format.substring(0, format.indexOf("-"));
        if (dates != null && dates.length >= 2) {//选定日期
            Date date1 = new Date(dates[0]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateStart = sdf.format(date1) + " 00:00:00";
            Date date2 = new Date(dates[1]);
            dateEnd = sdf.format(date2) + " 00:00:00";
        } else if (quarter != null && !"".equals(quarter)) {//季度
            if ("1".equals(quarter)) {
                quarterStart = yearStr + "-01-01 00:00:00";
                quarterEnd = yearStr + "-03-31 00:00:00";
            } else if ("2".equals(quarter)) {
                quarterStart = yearStr + "-04-01 00:00:00";
                quarterEnd = yearStr + "-06-31 00:00:00";
            } else if ("3".equals(quarter)) {
                quarterStart = yearStr + "-07-01 00:00:00";
                quarterEnd = yearStr + "-09-31 00:00:00";
            } else if ("4".equals(quarter)) {
                quarterStart = yearStr + "-10-01 00:00:00";
                quarterEnd = yearStr + "-12-31 00:00:00";
            }
        } else if (year != null && !"".equals(year)) {//年度
            if ("1".equals(year)) {
                //2020-01-01 00:00:00-2020-05-31 00:00:00
                yearStart = yearStr + "-01-01 00:00:00";
                yearEnd = yearStr + "-05-31 00:00:00";
            } else if ("2".equals(year)) {
                //2020-06-01 00:00:00-2020-12-31 00:00:00
                yearStart = yearStr + "-06-01 00:00:00";
                yearEnd = yearStr + "-12-31 00:00:00";
            }
        }
        return applicationFormDao.getExcelData(dateStart, dateEnd, quarterStart, quarterEnd, yearStart, yearEnd);
    }

    @Override
    public List<ProductExcelData> getExcelDataList(String[] date, String quarter, String year, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductExcelData> excelData = getExcelData(date, quarter, year);
        return excelData;
    }

    @Override
    @Transactional
    public int finish(Application application) {

        AtomicInteger count = new AtomicInteger();
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setId(application.getApplicationForm().getId());
        applicationForm.setApplyStatus(2);
        applicationForm.setModifyTime(new Date());
        applicationForm.setModifyOn(userServiceUtil.getUser().getId());
        applicationForm.setIsDelete(0);
        count.addAndGet(applicationFormMapper.updateByPrimaryKeySelective(applicationForm));
        application.getApplicationProducts().stream().forEach(applicationProduct -> {
            applicationProduct.setStatus(2);
            applicationProductMapper.updateByPrimaryKeySelective(applicationProduct);
        });

        return count.get();
    }

    @Override
    @Transactional
    public int cancel(Long id) {
        int count = 0;
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setId(id);
        applicationForm.setApplyStatus(3);
        count = applicationFormMapper.updateByPrimaryKeySelective(applicationForm);
        ApplicationProductExample example = new ApplicationProductExample();
        example.createCriteria().andMainidEqualTo(id);
        List<ApplicationProduct> applicationProducts = applicationProductMapper.selectByExample(example);
        applicationProducts.stream().forEach(product -> {
            ApplicationProduct applicationProduct = new ApplicationProduct();
            applicationProduct.setId(product.getId());
            applicationProduct.setStatus(0);
            applicationProductMapper.updateByPrimaryKeySelective(applicationProduct);
        });
        return count;
    }
}
