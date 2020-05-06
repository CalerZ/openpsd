package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Supplier;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface SupplierService {
    /**
     * 添加
     */
    int create(Supplier supplier);

    /**
     * 修改
     */
    int update(Supplier supplier);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);

    /**
     * 删除
     */
    int delete(Long id);

    /**
     * 查询单个
     */
    Supplier list(Long id);

    /**
     * 查询所有
     */
    List<Supplier> list();

    /**
     * 条件分页查询
     */
    List<Supplier> list(String keyword, Integer pageSize, Integer pageNum);



}
