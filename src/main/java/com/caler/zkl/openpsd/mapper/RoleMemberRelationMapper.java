package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.RoleMemberRelation;
import com.caler.zkl.openpsd.bean.RoleMemberRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMemberRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    long countByExample(RoleMemberRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int deleteByExample(RoleMemberRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int insert(RoleMemberRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int insertSelective(RoleMemberRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    List<RoleMemberRelation> selectByExample(RoleMemberRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    RoleMemberRelation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByExampleSelective(@Param("record") RoleMemberRelation record, @Param("example") RoleMemberRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByExample(@Param("record") RoleMemberRelation record, @Param("example") RoleMemberRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByPrimaryKeySelective(RoleMemberRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_member_relation
     *
     * @mbg.generated Sun Apr 26 11:05:26 CST 2020
     */
    int updateByPrimaryKey(RoleMemberRelation record);
}