package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.ApplicationForm;
import com.caler.zkl.openpsd.bean.ApplicationFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationFormMapper {
    long countByExample(ApplicationFormExample example);

    int deleteByExample(ApplicationFormExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplicationForm record);

    int insertSelective(ApplicationForm record);

    List<ApplicationForm> selectByExampleWithBLOBs(ApplicationFormExample example);

    List<ApplicationForm> selectByExample(ApplicationFormExample example);

    ApplicationForm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplicationForm record, @Param("example") ApplicationFormExample example);

    int updateByExampleWithBLOBs(@Param("record") ApplicationForm record, @Param("example") ApplicationFormExample example);

    int updateByExample(@Param("record") ApplicationForm record, @Param("example") ApplicationFormExample example);

    int updateByPrimaryKeySelective(ApplicationForm record);

    int updateByPrimaryKeyWithBLOBs(ApplicationForm record);

    int updateByPrimaryKey(ApplicationForm record);
}