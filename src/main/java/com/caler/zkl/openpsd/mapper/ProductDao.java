package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.common.ProductExcelData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    List<ProductBean> select(@Param("keyword") String keyword, @Param("typeid") Long typeid, @Param("status") Integer status, @Param("createrid") Long createrid);

    String selectMaxPartNo(@Param("tag") String tag);

    List<ProductExcelData> getExcelData(List<Long> ids);

    Stock selectStockByProductId(@Param("pid") Long pid);
    List< Supplier> selectSupplierByProductId(@Param("pid") Long pid);

    List<ProductPojo> selectPojo(@Param("keyword") String keyword, @Param("typeid") Long typeid, @Param("status") Integer status, @Param("createrid") Long createrid);
    ProductPojo selectOneProductPojo(@Param("id") Long id );
}