package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.bean.ResourceCategory;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ResourceCategoryService {
    /**
     * 添加
     */
    int create(ResourceCategory resourceCategory);

    /**
     * 修改
     */
    int update(ResourceCategory resourceCategory);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);

    /**
     * 删除一个
     */
    int delete(Long id);
    /**
     * 查询单个
     */
    ResourceCategory list(Long id);

    /**
     * 查询所有
     */
    List<ResourceCategory> list();
    /**
     * 查询所有
     */
    List<ResourceCategory> list(String keyword,Integer pageSize,Integer pageNum);


}
