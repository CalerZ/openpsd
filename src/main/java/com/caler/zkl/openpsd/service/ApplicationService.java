package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Application;
import com.caler.zkl.openpsd.common.ProductExcelData;

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
    Application list(Long id);

    /**
     * 查询所有
     */
    List<Application> list();

    /**
     * 条件分页查询
     */
    List<Application> list(String keyword, Integer pageSize, Integer pageNum);


    List<Application> myApplicationList(String keyword, Integer pageSize, Integer pageNum);

    List<Application> reviewedApplicationList(String keyword, Integer pageSize, Integer pageNum);

    int submit(Application application);

    String generateFormNo();

    int updateStatus(List<Long> ids);

    List<ProductExcelData> getExcelData(String[] date, String quarter, String year);

    List<ProductExcelData> getExcelDataList(String[] date, String quarter, String year, Integer pageSize, Integer pageNum);

    int finish(Application application);

    int cancel(Long id);
}
