package com.caler.zkl.openpsd.service;

import com.caler.zkl.openpsd.bean.SysDict;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface SysDictService {
    /**
     * 添加
     */
    int create(SysDict sysDict);

    /**
     * 修改
     */
    int update(SysDict sysDict);

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
    SysDict list(Long id);

    /**
     * 查询所有
     */
    List<SysDict> list();

    /**
     * 条件分页查询
     */
    List<SysDict> list(String keyword, Integer pageSize, Integer pageNum);



}
