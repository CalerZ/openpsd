package com.caler.zkl.openpsd.bean;

import java.io.Serializable;
import java.util.Date;

public class Resource implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.id
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.create_time
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.name
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.url
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.description
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.category_id
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    private Long categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.id
     *
     * @return the value of resource.id
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.id
     *
     * @param id the value for resource.id
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.create_time
     *
     * @return the value of resource.create_time
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.create_time
     *
     * @param createTime the value for resource.create_time
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.name
     *
     * @return the value of resource.name
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.name
     *
     * @param name the value for resource.name
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.url
     *
     * @return the value of resource.url
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.url
     *
     * @param url the value for resource.url
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.description
     *
     * @return the value of resource.description
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.description
     *
     * @param description the value for resource.description
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.category_id
     *
     * @return the value of resource.category_id
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.category_id
     *
     * @param categoryId the value for resource.category_id
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Fri May 01 13:15:31 CST 2020
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
        sb.append(", url=").append(url);
        sb.append(", description=").append(description);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}