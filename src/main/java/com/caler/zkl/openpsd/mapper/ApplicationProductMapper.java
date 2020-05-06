package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.ApplicationProduct;
import com.caler.zkl.openpsd.bean.ApplicationProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationProductMapper {
    long countByExample(ApplicationProductExample example);

    int deleteByExample(ApplicationProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplicationProduct record);

    int insertSelective(ApplicationProduct record);

    List<ApplicationProduct> selectByExampleWithBLOBs(ApplicationProductExample example);

    List<ApplicationProduct> selectByExample(ApplicationProductExample example);

    ApplicationProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplicationProduct record, @Param("example") ApplicationProductExample example);

    int updateByExampleWithBLOBs(@Param("record") ApplicationProduct record, @Param("example") ApplicationProductExample example);

    int updateByExample(@Param("record") ApplicationProduct record, @Param("example") ApplicationProductExample example);

    int updateByPrimaryKeySelective(ApplicationProduct record);

    int updateByPrimaryKeyWithBLOBs(ApplicationProduct record);

    int updateByPrimaryKey(ApplicationProduct record);
}