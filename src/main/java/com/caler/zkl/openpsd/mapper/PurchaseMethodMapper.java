package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.PurchaseMethod;
import com.caler.zkl.openpsd.bean.PurchaseMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseMethodMapper {
    long countByExample(PurchaseMethodExample example);

    int deleteByExample(PurchaseMethodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseMethod record);

    int insertSelective(PurchaseMethod record);

    List<PurchaseMethod> selectByExampleWithBLOBs(PurchaseMethodExample example);

    List<PurchaseMethod> selectByExample(PurchaseMethodExample example);

    PurchaseMethod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseMethod record, @Param("example") PurchaseMethodExample example);

    int updateByExampleWithBLOBs(@Param("record") PurchaseMethod record, @Param("example") PurchaseMethodExample example);

    int updateByExample(@Param("record") PurchaseMethod record, @Param("example") PurchaseMethodExample example);

    int updateByPrimaryKeySelective(PurchaseMethod record);

    int updateByPrimaryKeyWithBLOBs(PurchaseMethod record);

    int updateByPrimaryKey(PurchaseMethod record);
}