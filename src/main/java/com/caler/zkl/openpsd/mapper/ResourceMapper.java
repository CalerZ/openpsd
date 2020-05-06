package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.bean.ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    long countByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int deleteByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int insertSelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    List<Resource> selectByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    Resource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    int updateByPrimaryKey(Resource record);
}