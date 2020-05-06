package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Resource;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ResourceService {
    /**
     * 添加
     */
    int create(Resource mesource);

    /**
     * 修改
     */
    int update(Resource mesource);

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
    Resource list(Long id);

    /**
     * 查询所有
     */
    List<Resource> list();

    /**
     * 按关键字分页查询
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<Resource> list(String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * 条件分页查询
     */
    List<Resource> list(Resource mesource, Integer pageSize, Integer pageNum);


}
