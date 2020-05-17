package com.caler.zkl.openpsd.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-16 12:08
 * @description :
 */
@Data
public class ProductPojo {
    private Product product;
    private ProductType productType1;
    private ProductType productType2;
    private ProductUtil productUtil;
    private Stock stock;
    private Member member;
    private PurchaseMethod purchaseMethod;
    private List<Supplier> supplierList;
}
