package com.caler.zkl.openpsd.bean;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @author Caler_赵康乐
 * @create 2020-05-08 11:14
 * @description :
 */
@Data
public class ExcelData implements Comparable<ExcelData> {
    private String typeName;
    private List<Product> products;


    @Override
    public int compareTo(ExcelData o) {
        return this.getTypeName().compareTo(o.getTypeName());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcelData excelData = (ExcelData) o;
        return Objects.equals(typeName, excelData.typeName) &&
                Objects.equals(products, excelData.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName, products);
    }
}
