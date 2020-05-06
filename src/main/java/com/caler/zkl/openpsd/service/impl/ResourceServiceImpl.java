package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.bean.ResourceExample;
import com.caler.zkl.openpsd.mapper.ResourceMapper;
import com.caler.zkl.openpsd.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;



    @Override
    public int create(Resource resource) {
        resource.setCreateTime(new Date());
        return resourceMapper.insertSelective(resource);
    }

    @Override
    public int update(Resource resource) {
        return resourceMapper.updateByPrimaryKeySelective(resource);
    }

    @Override
    public int delete(List<Long> ids) {//删除上级下级一起删除
        int count = 0;
        for (long id : ids) {
            count += resourceMapper.deleteByPrimaryKey(id);
            ResourceExample example = new ResourceExample();
        }
        return count;
    }
    @Override
    public int delete(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Resource list(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Resource> list() {
        return resourceMapper.selectByExample(null);
    }

    @Override
    public List<Resource> list(String nameKeyword, String urlKeyword,  Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ResourceExample example = new ResourceExample();
        if (nameKeyword != null) {
            example.createCriteria().andNameLike("%" + nameKeyword + "%");
        }
        if (urlKeyword != null) {
            example.createCriteria().andUrlLike("%" + urlKeyword + "%");
        }
        //设置条件
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<Resource> list(Resource resource, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ResourceExample example = new ResourceExample();
        //设置条件
        return resourceMapper.selectByExample(example);
    }


}
