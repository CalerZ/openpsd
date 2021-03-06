package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.MemberLevel;
import com.caler.zkl.openpsd.bean.MemberLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberLevelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    long countByExample(MemberLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int deleteByExample(MemberLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int insert(MemberLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int insertSelective(MemberLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    List<MemberLevel> selectByExample(MemberLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    MemberLevel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByExampleSelective(@Param("record") MemberLevel record, @Param("example") MemberLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByExample(@Param("record") MemberLevel record, @Param("example") MemberLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByPrimaryKeySelective(MemberLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_level
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByPrimaryKey(MemberLevel record);
}