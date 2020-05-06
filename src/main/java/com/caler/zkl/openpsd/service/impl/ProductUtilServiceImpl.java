package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.ProductUtil;
import com.caler.zkl.openpsd.bean.ProductUtilExample;
import com.caler.zkl.openpsd.mapper.ProductUtilMapper;
import com.caler.zkl.openpsd.service.ProductUtilService;
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
public class ProductUtilServiceImpl implements ProductUtilService {

    @Autowired
    private ProductUtilMapper memberMapper;

    @Override
    public int create(ProductUtil member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public int update(ProductUtil member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id:ids) {
           count+= memberMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductUtil list(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductUtil> list() {
        return memberMapper.selectByExample(null);
    }

    @Override
    public List<ProductUtil> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ProductUtilExample example = new ProductUtilExample();
        //设置条件
        return memberMapper.selectByExample(example);
    }
}
