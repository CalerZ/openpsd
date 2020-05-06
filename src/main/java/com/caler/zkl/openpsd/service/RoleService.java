package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Menu;
import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.bean.Role;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface RoleService {
    /**
     * 添加
     */
    int create(Role role);

    /**
     * 修改
     */
    int update(Role role);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    /**
     * 查询单个
     */
    Role list(Long id);

    /**
     * 查询所有
     */
    List<Role> list();

    /**
     * 按关键字分页查询
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<Role> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 条件分页查询
     */
    List<Role> list(Role role, Integer pageSize, Integer pageNum);


    /**
     * 根据角色id查询资源
     * @param id
     * @return
     */
    List<Resource> getListResourceById(Long id);

    int allocResource(Long roleId, List<Long> resourceIds);

    List<Menu> listMenu(Long id);

    int allocMenu(Long roleId, List<Long> menuIds);
}
