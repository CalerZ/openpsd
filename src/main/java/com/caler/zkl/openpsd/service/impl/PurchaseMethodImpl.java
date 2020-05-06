package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.util.StrUtil;
import com.caler.zkl.openpsd.bean.PurchaseMethod;
import com.caler.zkl.openpsd.bean.PurchaseMethodExample;
import com.caler.zkl.openpsd.mapper.PurchaseMethodMapper;
import com.caler.zkl.openpsd.service.PurchaseMethodService;
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
public class PurchaseMethodImpl implements PurchaseMethodService {

    @Autowired
    private PurchaseMethodMapper purchaseMethodMapper;

    @Override
    public int create(PurchaseMethod purchaseMethod) {
        return purchaseMethodMapper.insertSelective(purchaseMethod);
    }

    @Override
    public int update(PurchaseMethod purchaseMethod) {
        return purchaseMethodMapper.updateByPrimaryKeySelective(purchaseMethod);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id : ids) {
            count += purchaseMethodMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return purchaseMethodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PurchaseMethod list(Long id) {
        return purchaseMethodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PurchaseMethod> list() {
        return purchaseMethodMapper.selectByExample(null);
    }

    @Override
    public List<PurchaseMethod> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PurchaseMethodExample example = new PurchaseMethodExample();
        if (!StrUtil.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        example.setOrderByClause("sort");
        return purchaseMethodMapper.selectByExampleWithBLOBs(example);
    }
}
