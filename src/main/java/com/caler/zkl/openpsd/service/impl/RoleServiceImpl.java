package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.*;
import com.caler.zkl.openpsd.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleExtendMapper roleExtendMapper;

    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private RoleMenuRelationMapper roleMenuRelationMapper;

    @Override
    public int create(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.insertSelective(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id : ids) {
            count += roleMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public Role list(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> list() {
        return roleMapper.selectByExample(null);
    }

    @Override
    public List<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        if (keyword != null) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        //设置条件
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<Role> list(Role role, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        //设置条件
        return roleMapper.selectByExample(example);
    }


    @Override
    public List<Resource> getListResourceById(Long id) {
        return roleExtendMapper.selectResourceByRoleId(id);
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {

        //删除
        RoleResourceRelationExample example = new RoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationMapper.deleteByExample(example);
        //添加
        int count = 0;
        RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
        roleResourceRelation.setRoleId(roleId);
        for (Long resourceId : resourceIds) {
            roleResourceRelation.setResourceId(resourceId);
            count += roleResourceRelationMapper.insertSelective(roleResourceRelation);
        }
        return count;
    }

    @Override
    public List<Menu> listMenu(Long id) {
        return roleExtendMapper.selectMenuByRoleId(id);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //删除
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);
        //添加
        int count = 0;
        RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
        roleMenuRelation.setRoleId(roleId);
        for (Long menuId : menuIds) {
            roleMenuRelation.setMenuId(menuId);
            count += roleMenuRelationMapper.insertSelective(roleMenuRelation);
        }
        return count;

    }


}
