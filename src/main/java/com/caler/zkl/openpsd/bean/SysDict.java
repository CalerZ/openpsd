package com.caler.zkl.openpsd.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SysDict implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = " 父ID ")
    private Integer pid;

    @ApiModelProperty(value = " 数据类别,首字母大写 ")
    private String dataType;

    @ApiModelProperty(value = " 数据编码 ")
    private String dataCode;

    @ApiModelProperty(value = " 数据名称/值 ")
    private String dataValue;

    @ApiModelProperty(value = " 顺序 ")
    private Integer sort;

    @ApiModelProperty(value = "0正常,1删除")
    private Byte status;

    @ApiModelProperty(value = "0默认为不固定,1固定")
    private Byte isFixed;

    @ApiModelProperty(value = "数据描述")
    private String dataDesc;

    private Date updateIme;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(Byte isFixed) {
        this.isFixed = isFixed;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public Date getUpdateIme() {
        return updateIme;
    }

    public void setUpdateIme(Date updateIme) {
        this.updateIme = updateIme;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", dataType=").append(dataType);
        sb.append(", dataCode=").append(dataCode);
        sb.append(", dataValue=").append(dataValue);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", isFixed=").append(isFixed);
        sb.append(", dataDesc=").append(dataDesc);
        sb.append(", updateIme=").append(updateIme);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}