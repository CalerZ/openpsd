package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.PurchaseMethod;

import java.util.List;


public interface PurchaseMethodService {
    /**
     * 添加
     */
    int create(PurchaseMethod purchaseMethod);

    /**
     * 修改
     */
    int update(PurchaseMethod purchaseMethod);

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
    PurchaseMethod list(Long id);

    /**
     * 查询所有
     */
    List<PurchaseMethod> list();

    /**
     * 条件分页查询
     */
    List<PurchaseMethod> list(String keyword, Integer pageSize, Integer pageNum);



}
