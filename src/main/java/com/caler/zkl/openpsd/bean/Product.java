package com.caler.zkl.openpsd.bean;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Product implements Serializable {
    @ApiModelProperty(value = "序号")
    private Long id;

    @ApiModelProperty(value = "物品名称")
    private String name;

    @ApiModelProperty(value = "一级类型")
    private Long type1;

    @ApiModelProperty(value = "二级类型")
    private Long type2;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "单位")
    private Long unit;

    @ApiModelProperty(value = "参考单价")
    private Double price;

    @ApiModelProperty(value = "标准")
    private String standard;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人")
    private Long createOn;

    @ApiModelProperty(value = "修改时间")
    private String modifyTime;

    @ApiModelProperty(value = "修改人")
    private Long modifyOn;

    @ApiModelProperty(value = "供应商ids")
    private String supplierId;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;

    @ApiModelProperty(value = "物品编码")
    private String code;

    @ApiModelProperty(value = "描述")
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getType1() {
        return type1;
    }

    public void setType1(Long type1) {
        this.type1 = type1;
    }

    public Long getType2() {
        return type2;
    }

    public void setType2(Long type2) {
        this.type2 = type2;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Long createOn) {
        this.createOn = createOn;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(Long modifyOn) {
        this.modifyOn = modifyOn;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type1=").append(type1);
        sb.append(", type2=").append(type2);
        sb.append(", specifications=").append(specifications);
        sb.append(", unit=").append(unit);
        sb.append(", price=").append(price);
        sb.append(", standard=").append(standard);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createOn=").append(createOn);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifyOn=").append(modifyOn);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}