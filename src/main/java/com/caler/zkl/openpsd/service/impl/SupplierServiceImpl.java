package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.util.StrUtil;
import com.caler.zkl.openpsd.bean.Supplier;
import com.caler.zkl.openpsd.bean.SupplierExample;
import com.caler.zkl.openpsd.mapper.SupplierMapper;
import com.caler.zkl.openpsd.service.SupplierService;
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
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public int create(Supplier supplier) {
        return supplierMapper.insertSelective(supplier);
    }

    @Override
    public int update(Supplier supplier) {
        return supplierMapper.updateByPrimaryKeySelective(supplier);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id:ids) {
           count+= supplierMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return supplierMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Supplier list(Long id) {
        return supplierMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Supplier> list() {
        return supplierMapper.selectByExample(null);
    }

    @Override
    public List<Supplier> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SupplierExample example = new SupplierExample();
        if(!StrUtil.isEmpty(keyword)){
            example.createCriteria().andNameLike("%"+keyword+"%");
            example.or(example.createCriteria().andCodeLike("%"+keyword+"%"));
        }
        example.setOrderByClause("sort");
        return supplierMapper.selectByExampleWithBLOBs(example);
    }
}
