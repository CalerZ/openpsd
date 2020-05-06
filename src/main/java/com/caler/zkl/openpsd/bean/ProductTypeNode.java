package com.caler.zkl.openpsd.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-03 14:35
 * @description :
 */
@Data
public class ProductTypeNode extends ProductType {
    private List<ProductTypeNode>  children;
}
