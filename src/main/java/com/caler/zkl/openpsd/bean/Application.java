package com.caler.zkl.openpsd.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-04 10:21
 * @description :
 */
@Data
public class Application {
    private ApplicationForm applicationForm;
    private List<ApplicationProduct> applicationProducts;
}
