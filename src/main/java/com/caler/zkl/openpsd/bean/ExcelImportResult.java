package com.caler.zkl.openpsd.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Caler_赵康乐
 * @create 2020-05-16 9:16
 * @description :
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExcelImportResult {
    private String productName;
    private String type;
    private String result;
    private String message;
}
