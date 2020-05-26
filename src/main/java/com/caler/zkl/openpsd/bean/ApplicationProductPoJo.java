package com.caler.zkl.openpsd.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-25 18:55
 * @description :
 */
@Data
public class ApplicationProductPoJo {

    private ApplicationForm applicationForm;

    private List<ProductPojo> applicationProducts;
}
