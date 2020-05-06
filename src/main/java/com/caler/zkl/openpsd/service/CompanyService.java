package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Company;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface CompanyService {
    /**
     * 添加
     */
    int create(Company mompany);

    /**
     * 修改
     */
    int update(Company mompany);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    /**
     * 查询单个
     */
    Company list(Long id);

    /**
     * 查询所有
     */
    List<Company> list();

    /**
     * 条件分页查询
     */
    List<Company> list(String keyword, Integer pageSize, Integer pageNum);


    int  delete(Long id);
}
