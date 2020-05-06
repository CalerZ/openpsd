package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Menu;
import com.caler.zkl.openpsd.bean.MenuNode;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface MenuService {
    /**
     * 添加
     */
    int create(Menu menu);

    /**
     * 修改
     */
    int update(Menu menu);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    /**
     * 查询单个
     */
    Menu list(Long id);

    /**
     * 查询所有
     */
    List<Menu> list();

    /**
     * 按关键字分页查询
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<Menu> list(Long pid,String keyword, Integer pageSize, Integer pageNum);

    /**
     * 条件分页查询
     */
    List<Menu> list(Menu menu, Integer pageSize, Integer pageNum);


    List<MenuNode> treeList();
}
