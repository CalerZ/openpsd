package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.ResourceCategory;
import com.caler.zkl.openpsd.bean.ResourceCategoryExample;
import com.caler.zkl.openpsd.bean.RoleExample;
import com.caler.zkl.openpsd.mapper.ResourceCategoryMapper;
import com.caler.zkl.openpsd.service.ResourceCategoryService;
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
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;


    @Override
    public int create(ResourceCategory resourceCategory) {
        resourceCategory.setCreateTime(new Date());
        return resourceCategoryMapper.insertSelective(resourceCategory);
    }

    @Override
    public int update(ResourceCategory resourceCategory) {
        return resourceCategoryMapper.updateByPrimaryKeySelective(resourceCategory);
    }

    @Override
    public int delete(List<Long> ids) {//删除上级下级一起删除
        int count = 0;
        for (long id : ids) {
            count += resourceCategoryMapper.deleteByPrimaryKey(id);
            ResourceCategoryExample example = new ResourceCategoryExample();
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return resourceCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ResourceCategory list(Long id) {
        return resourceCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ResourceCategory> list() {
        return resourceCategoryMapper.selectByExample(null);
    }

    @Override
    public List<ResourceCategory> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ResourceCategoryExample example = new ResourceCategoryExample();
        if (keyword != null)
            example.createCriteria().andNameLike("%" + keyword + "%");
        //设置条件
        example.setOrderByClause("sort");
        return resourceCategoryMapper.selectByExample(example);
    }
}
