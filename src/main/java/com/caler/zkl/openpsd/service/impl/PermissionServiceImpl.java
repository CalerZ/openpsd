package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.Permission;
import com.caler.zkl.openpsd.bean.PermissionExample;
import com.caler.zkl.openpsd.mapper.PermissionMapper;
import com.caler.zkl.openpsd.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int create(Permission permission) {
        return permissionMapper.insertSelective(permission);
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id:ids) {
           count+= permissionMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public Permission list(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> list() {
        return permissionMapper.selectByExample(null);
    }

    @Override
    public List<Permission> list(Permission permission, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PermissionExample example = new PermissionExample();
        //设置条件
        return permissionMapper.selectByExample(example);
    }

    @Override
    public List<Permission> getPermissionByMemberId(Long memberid) {
        return permissionMapper.selectByMemberId(memberid);
    }
}
