package com.caler.zkl.openpsd.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Caler_赵康乐
 * @create 2020-05-17 15:50
 * @description :
 */
@Data
public class ApplicationProductBean  extends ApplicationProduct{

    @ApiModelProperty(value = "一级类型名称")
    private String type1Name;

    @ApiModelProperty(value = "二级类型名称")
    private String type2Name;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "录入人名称")
    private String recordOnName;

    @ApiModelProperty(value = "采购方式名称")
    private String purchaseMethodName;

}
