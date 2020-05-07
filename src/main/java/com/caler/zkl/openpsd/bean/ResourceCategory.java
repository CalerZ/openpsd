package com.caler.zkl.openpsd.bean;

import java.io.Serializable;
import java.util.Date;

public class ResourceCategory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_category.id
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_category.create_time
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_category.name
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_category.sort
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource_category
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_category.id
     *
     * @return the value of resource_category.id
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_category.id
     *
     * @param id the value for resource_category.id
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_category.create_time
     *
     * @return the value of resource_category.create_time
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_category.create_time
     *
     * @param createTime the value for resource_category.create_time
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_category.name
     *
     * @return the value of resource_category.name
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_category.name
     *
     * @param name the value for resource_category.name
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_category.sort
     *
     * @return the value of resource_category.sort
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_category.sort
     *
     * @param sort the value for resource_category.sort
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Fri May 01 17:43:56 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}