package com.caler.zkl.openpsd.bean;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Stock implements Serializable {
    private Long id;

    @ApiModelProperty(value = "安全库存")
    private Double safetyStock;

    @ApiModelProperty(value = "上月数量")
    private Double lastMonthQuantity;

    @ApiModelProperty(value = "现有库存")
    private Double onHandInventory;

    @ApiModelProperty(value = "本月提报数量")
    private Double reportedQuantity;

    @ApiModelProperty(value = "物品id")
    private Long productId;

    @ApiModelProperty(value = "物品编码")
    private String productCode;

    @ApiModelProperty(value = "采购方式")
    private Long purchaseMethod;

    @ApiModelProperty(value = "生产线人数")
    private Integer prodLineMembers;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", safetyStock=").append(safetyStock);
        sb.append(", lastMonthQuantity=").append(lastMonthQuantity);
        sb.append(", onHandInventory=").append(onHandInventory);
        sb.append(", reportedQuantity=").append(reportedQuantity);
        sb.append(", productId=").append(productId);
        sb.append(", productCode=").append(productCode);
        sb.append(", purchaseMethod=").append(purchaseMethod);
        sb.append(", prodLineMembers=").append(prodLineMembers);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}