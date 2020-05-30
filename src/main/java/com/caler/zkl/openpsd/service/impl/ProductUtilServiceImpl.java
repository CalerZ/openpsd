package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.ProductUtil;
import com.caler.zkl.openpsd.bean.ProductUtilExample;
import com.caler.zkl.openpsd.mapper.ProductUtilMapper;
import com.caler.zkl.openpsd.service.ProductUtilService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class ProductUtilServiceImpl implements ProductUtilService {

    @Autowired
    private ProductUtilMapper productUtilMapper;

    @Override
    public int create(ProductUtil member) {
        return productUtilMapper.insertSelective(member);
    }

    @Override
    public int update(ProductUtil member) {
        return productUtilMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id:ids) {
           count+= productUtilMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return productUtilMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductUtil list(Long id) {
        return productUtilMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductUtil> list() {
        ProductUtilExample example = new ProductUtilExample();
        example.createCriteria().andStatusEqualTo(1);
        return productUtilMapper.selectByExample(example);
    }

    @Override
    public List<ProductUtil> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ProductUtilExample example = new ProductUtilExample();
        example.setOrderByClause("sort");
        //设置条件
        return productUtilMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        ProductUtil productUtil = new ProductUtil();
        productUtil.setId(id);
        productUtil.setStatus(status);
        return productUtilMapper.updateByPrimaryKeySelective(productUtil);
    }

    @Override
    public int sealed(List<Long> ids) {
        AtomicInteger count = new AtomicInteger();
        ids.forEach(item->{
            count.getAndAdd(updateStatus(item,2))  ;
        });
        return count.get();
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        int count=0;
        for (Long id : ids) {
            ProductUtil productUtil = new ProductUtil();
            productUtil.setId(id);
            productUtil.setStatus(status);
            count+=productUtilMapper.updateByPrimaryKeySelective(productUtil);
        }
        return count;
    }
}
