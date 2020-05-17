package com.caler.zkl.openpsd.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Caler_赵康乐
 * @create 2020-05-09 16:30
 * @description :
 */
@Data
public class ApplicationFormBean extends  ApplicationForm{
    @ApiModelProperty(value = "申请人公司名称")
    private String companyName;
    @ApiModelProperty(value = "申请人名称")
    private String createrName;
    @ApiModelProperty(value = "审核人名称")
    private String approverName;

}
