package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.*;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ProductService {
    /**
     * 添加
     */
    int create(ProductDetail productDetail);

    /**
     * 修改
     */
    int update(ProductDetail productDetail);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    /**
     * 查询单个
     */
    ProductDetail list(Long id);
    /**
     * 查询单个
     */
    ProductPojo selectOne(Long id);

    /**
     * 查询所有
     */
    List<Product> list();

    /**
     * 条件分页查询
     */
    List<ProductBean> list(String keyword, Long typeid, Integer status, Long createrid, Integer pageSize, Integer pageNum);


    int delete(Long id);

    List<PurchaseMethod> purchaseMethodlist();

    List<ProductPojo> applicationProductList(List<Long> ids);

    String getProductNo(Long type1,Long type2);

    int  updateStatus(Long id, String status);
}
