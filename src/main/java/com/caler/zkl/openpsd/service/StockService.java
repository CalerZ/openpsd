package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.ProductUtil;
import com.caler.zkl.openpsd.bean.Stock;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface StockService {
    /**
     * 添加
     */
    int create(Stock stock);

    /**
     * 修改
     */
    int update(Stock stock);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);

    int delete(Long id);
    /**
     * 查询单个
     */
    Stock list(Long id);

    /**
     * 查询所有
     */
    List<Stock> list();

    /**
     * 条件分页查询
     */
    List<Stock> list(String keyword, Integer pageSize, Integer pageNum);



}
