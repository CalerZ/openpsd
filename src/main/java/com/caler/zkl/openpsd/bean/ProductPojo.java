package com.caler.zkl.openpsd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-16 12:08
 * @description :
 */
@Data
public class ProductPojo  extends  Product implements Serializable {
    private Long productId;
    @JsonIgnoreProperties(value = { "handler" })
    private ProductType productType1;
    @JsonIgnoreProperties(value = { "handler" })
    private ProductType productType2;
    @JsonIgnoreProperties(value = { "handler" })
    private ProductUtil productUtil;
    @JsonIgnoreProperties(value = { "handler" })
    private Stock stock;
    @JsonIgnoreProperties(value = { "handler" })
    private Member member;
    @JsonIgnoreProperties(value = { "handler" })
    private PurchaseMethod purchaseMethod;
    @JsonIgnoreProperties(value = { "handler" })
    private List<Supplier> supplierList;
}
