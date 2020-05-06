package com.caler.zkl.openpsd.bean;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ApplicationProduct implements Serializable {
    private Long id;

    @ApiModelProperty(value = "物品id")
    private Long productId;

    @ApiModelProperty(value = "物品编码")
    private String productCode;

    @ApiModelProperty(value = "一级类型")
    private Long type1;

    @ApiModelProperty(value = "二级类型")
    private Long type2;

    @ApiModelProperty(value = "物品名称")
    private String productName;

    @ApiModelProperty(value = "申请单id")
    private Long mainid;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "单位")
    private Long unit;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "标准")
    private String standard;

    @ApiModelProperty(value = "供应商")
    private Long supplierId;

    @ApiModelProperty(value = "安全库存")
    private Double safetyStock;

    @ApiModelProperty(value = "上月数量")
    private Double lastMonthQuantity;

    @ApiModelProperty(value = "现有库存")
    private Double onHandInventory;

    @ApiModelProperty(value = "现有库存")
    private Double reportedQuantity;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;

    @ApiModelProperty(value = "录入时间")
    private Date recordTime;

    @ApiModelProperty(value = "录入人")
    private Long recordOn;

    @ApiModelProperty(value = "采购方式")
    private Long purchaseMethod;

    @ApiModelProperty(value = "生产线人数")
    private Integer prodLineMembers;

    @ApiModelProperty(value = "物品描述")
    private String description;

    @ApiModelProperty(value = "备注")
    private String note;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getMainid() {
        return mainid;
    }

    public void setMainid(Long mainid) {
        this.mainid = mainid;
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Double getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Double safetyStock) {
        this.safetyStock = safetyStock;
    }

    public Double getLastMonthQuantity() {
        return lastMonthQuantity;
    }

    public void setLastMonthQuantity(Double lastMonthQuantity) {
        this.lastMonthQuantity = lastMonthQuantity;
    }

    public Double getOnHandInventory() {
        return onHandInventory;
    }

    public void setOnHandInventory(Double onHandInventory) {
        this.onHandInventory = onHandInventory;
    }

    public Double getReportedQuantity() {
        return reportedQuantity;
    }

    public void setReportedQuantity(Double reportedQuantity) {
        this.reportedQuantity = reportedQuantity;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Long getRecordOn() {
        return recordOn;
    }

    public void setRecordOn(Long recordOn) {
        this.recordOn = recordOn;
    }

    public Long getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(Long purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    public Integer getProdLineMembers() {
        return prodLineMembers;
    }

    public void setProdLineMembers(Integer prodLineMembers) {
        this.prodLineMembers = prodLineMembers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", productCode=").append(productCode);
        sb.append(", type1=").append(type1);
        sb.append(", type2=").append(type2);
        sb.append(", productName=").append(productName);
        sb.append(", mainid=").append(mainid);
        sb.append(", specifications=").append(specifications);
        sb.append(", unit=").append(unit);
        sb.append(", price=").append(price);
        sb.append(", standard=").append(standard);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", safetyStock=").append(safetyStock);
        sb.append(", lastMonthQuantity=").append(lastMonthQuantity);
        sb.append(", onHandInventory=").append(onHandInventory);
        sb.append(", reportedQuantity=").append(reportedQuantity);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", recordOn=").append(recordOn);
        sb.append(", purchaseMethod=").append(purchaseMethod);
        sb.append(", prodLineMembers=").append(prodLineMembers);
        sb.append(", description=").append(description);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}