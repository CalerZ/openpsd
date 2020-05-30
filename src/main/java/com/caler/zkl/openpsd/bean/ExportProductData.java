package com.caler.zkl.openpsd.bean;

import com.caler.zkl.openpsd.anno.ExcelColumn;
import lombok.Data;

/**
 * @author Caler_赵康乐
 * @create 2020-04-29 9:04
 * @description :
 */
@Data
public class ExportProductData {
    @ExcelColumn(value = "序号", col = 1)
    private String noid;

    @ExcelColumn(value = "类型", col = 2)
    private String type;


    @ExcelColumn(value = "物品名称", col = 3)
    private String productName;

    @ExcelColumn(value = "规格", col = 4)
    private String specifications ;

    @ExcelColumn(value = "单位", col = 5)
    private String unit ;

    @ExcelColumn(value = "单价", col = 6)
    private String price ;

    @ExcelColumn(value = "标准", col =7)
    private String standard ;

    @ExcelColumn(value = "生产线人数", col = 8)
    private String prodLineMembers;

    @ExcelColumn(value = "安全库存", col = 9)
    private String safetyStock;

    @ExcelColumn(value = "上月数量", col = 10)
    private String lastMonthQuantity ;

    @ExcelColumn(value = "现有库存", col = 11)
    private String onHandInventory;

    @ExcelColumn(value = "本月提报数量", col = 12)
    private String reportedQuantity ;

    @ExcelColumn(value = "采购方式", col = 13)
    private String purchaseMethod;




}
