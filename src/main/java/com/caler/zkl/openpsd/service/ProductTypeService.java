package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.ProductType;
import com.caler.zkl.openpsd.bean.ProductTypeNode;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ProductTypeService {
    /**
     * 添加
     */
    int create(ProductType productType);

    /**
     * 修改
     */
    int update(ProductType productType);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    int delete(Long id);

    /**
     * 查询单个
     */
    ProductType list(Long id);

    /**
     * 查询所有
     */
    List<ProductType> list();

    /**
     * 条件分页查询
     */

    List<ProductType> list(Long pid,String keyword, Integer pageSize, Integer pageNum);

    List<ProductTypeNode> treeList();
}
