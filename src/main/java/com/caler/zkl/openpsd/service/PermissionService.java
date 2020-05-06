package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Permission;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface PermissionService {
    /**
     * 添加
     */
    int create(Permission permission);

    /**
     * 修改
     */
    int update(Permission permission);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    /**
     * 查询单个
     */
    Permission list(Long id);

    /**
     * 查询所有
     */
    List<Permission> list();

    /**
     * 条件分页查询
     */
    List<Permission> list(Permission permission, Integer pageSize, Integer pageNum);
    /**
     * 查询所有
     */
    List<Permission> getPermissionByMemberId(Long memberid);


}
