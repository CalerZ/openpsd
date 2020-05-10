package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.SysDict;
import com.caler.zkl.openpsd.bean.SysDictExample;
import com.caler.zkl.openpsd.mapper.SysDictMapper;
import com.caler.zkl.openpsd.service.SysDictService;
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
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public int create(SysDict sysDict) {
        return sysDictMapper.insertSelective(sysDict);
    }

    @Override
    public int update(SysDict sysDict) {
        return sysDictMapper.updateByPrimaryKeySelective(sysDict);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id:ids) {
           count+= sysDictMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return sysDictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysDict list(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysDict> list() {
        return sysDictMapper.selectByExample(null);
    }

    @Override
    public List<SysDict> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SysDictExample example = new SysDictExample();
        //设置条件
        return sysDictMapper.selectByExample(example);
    }
}
