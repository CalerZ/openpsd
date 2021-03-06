package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Application;
import com.caler.zkl.openpsd.bean.ApplicationFormBean;
import com.caler.zkl.openpsd.bean.ApplicationProductPoJo;
import com.caler.zkl.openpsd.bean.ExportProductData;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ApplicationService {
    /**
     * 添加
     */
    int create(Application application);

    /**
     * 修改
     */
    int update(Application application);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);

    int delete(Long id);

    /**
     * 查询单个
     */
    ApplicationProductPoJo list(Long id);

    /**
     * 查询所有
     */
    List<Application> list();

    /**
     * 条件分页查询
     */
    List<ApplicationFormBean> list(String keyword, Integer pageSize, Integer pageNum);


    List<ApplicationFormBean> myApplicationList(String keyword,Integer status,String date1,String date2, Integer pageSize, Integer pageNum);

    List<ApplicationFormBean> reviewedApplicationList(String keyword,String  applyUser,String  date1,String  date2, Integer pageSize, Integer pageNum);

    List<ApplicationFormBean> finishApplicationList(String keyword,String  applyUser,String  date1,String  date2, Integer pageSize, Integer pageNum);

    int submit(Application application);

    String generateFormNo();

    int updateStatus(List<Long> ids);

    List<ExportProductData> getExcelData(String date1, String date2, String quarter, String year);

    List<ExportProductData> getExcelDataList(String date1, String date2, String quarter, String year, Integer pageSize, Integer pageNum);

    int finish(Application applicationBean);

    int cancel(Long id);
}
