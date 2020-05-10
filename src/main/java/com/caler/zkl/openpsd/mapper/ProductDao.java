package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.Product;
import com.caler.zkl.openpsd.bean.ProductBean;
import com.caler.zkl.openpsd.bean.ProductExample;
import com.caler.zkl.openpsd.common.ProductExcelData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    List<ProductBean> select(@Param("keyword") String keyword, @Param("typeid") Long typeid, @Param("status") Integer status, @Param("createrid") Long createrid);

    String selectMaxPartNo(@Param("tag") String tag);

    List<ProductExcelData> getExcelData(List<Long> ids);
}