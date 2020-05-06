package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.Stock;
import com.caler.zkl.openpsd.bean.StockExample;
import com.caler.zkl.openpsd.mapper.StockMapper;
import com.caler.zkl.openpsd.service.StockService;
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
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public int create(Stock stock) {
        return stockMapper.insertSelective(stock);
    }

    @Override
    public int update(Stock stock) {
        return stockMapper.updateByPrimaryKeySelective(stock);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id:ids) {
           count+= stockMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return stockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Stock list(Long id) {
        return stockMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Stock> list() {
        return stockMapper.selectByExample(null);
    }

    @Override
    public List<Stock> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        StockExample example = new StockExample();
        //设置条件
        return stockMapper.selectByExample(example);
    }
}
