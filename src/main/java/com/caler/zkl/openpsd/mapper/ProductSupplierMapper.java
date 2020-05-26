package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.ProductSupplier;
import com.caler.zkl.openpsd.bean.ProductSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSupplierMapper {
    long countByExample(ProductSupplierExample example);

    int deleteByExample(ProductSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductSupplier record);

    int insertSelective(ProductSupplier record);

    List<ProductSupplier> selectByExample(ProductSupplierExample example);

    ProductSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductSupplier record, @Param("example") ProductSupplierExample example);

    int updateByExample(@Param("record") ProductSupplier record, @Param("example") ProductSupplierExample example);

    int updateByPrimaryKeySelective(ProductSupplier record);

    int updateByPrimaryKey(ProductSupplier record);
}