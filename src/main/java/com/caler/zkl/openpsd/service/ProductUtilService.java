package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.ProductUtil;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ProductUtilService {
    /**
     * 添加
     */
    int create(ProductUtil member);

    /**
     * 修改
     */
    int update(ProductUtil member);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);

    int delete(Long id);
    /**
     * 查询单个
     */
    ProductUtil list(Long id);

    /**
     * 查询所有
     */
    List<ProductUtil> list();

    /**
     * 条件分页查询
     */
    List<ProductUtil> list(String keyword, Integer pageSize, Integer pageNum);



}
