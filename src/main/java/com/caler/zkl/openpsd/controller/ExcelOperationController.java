package com.caler.zkl.openpsd.controller;

import java.io.IOException;
import java.util.*;

import com.caler.zkl.openpsd.bean.ExcelData;
import com.caler.zkl.openpsd.bean.Product;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.common.ProductExcelData;
import com.caler.zkl.openpsd.mapper.ProductMapper;
import com.caler.zkl.openpsd.util.ExcelUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/info")
public class ExcelOperationController {
    private static final Logger log = LogManager.getLogger(ExcelOperationController.class);


    @Autowired
    private ProductMapper productMapper;

    /**
     * 导出excel
     *
     * @param response
     * @throws IOException
     */
    @PostMapping("/exportExcel")
    public CommonResult exportExcel(@RequestBody List<Long> ids, HttpServletResponse response) throws IOException {
        log.info(ids);
        if (ids == null || ids.size() == 0) {
            return CommonResult.success(null);
        }
        //根据id去查询分类
        Set<ExcelData> set = new TreeSet();
        ids.forEach(item -> {
//            //根据id选取分类
//            Product product = productMapper.selectByPrimaryKey(item);
//            String typeName = product.getType1() + "(" + product.getType2() + ")";
//            ExcelData excelData =  set.stream().filter(t -> {
//                if (!t.getTypeName().equals(typeName)) {
//                    ExcelData data = new ExcelData();
//                    data.setTypeName(typeName);
//                    set.add(data);
//                    return true;
//                }else{
//                    return false;
//                }
//            }).;


        });

        List<ProductExcelData> resultList = new ArrayList<ProductExcelData>();
        for (int i = 0; i < 100; i++) {
            ProductExcelData productExcelData = new ProductExcelData();
            productExcelData.setNoid(i + "");
            productExcelData.setType("类型" + i);
            productExcelData.setProductName("物品名称" + i);
            productExcelData.setSpecifications("规格" + i);
            productExcelData.setUnit(i + "");
            productExcelData.setPrice(i + "");
            productExcelData.setStandard("标准" + i);
            productExcelData.setProdLineMembers(i + "");
            productExcelData.setSafetyStock(i + "");
            productExcelData.setLastMonthQuantity(i + "");
            productExcelData.setOnHandInventory(i + "");
            productExcelData.setReportedQuantity("" + i);
            productExcelData.setPurchaseMethod(i + "");
            resultList.add(productExcelData);
        }
        long t1 = System.currentTimeMillis();
        ExcelUtil.writeExcel(response, resultList, ProductExcelData.class);
        long t2 = System.currentTimeMillis();
        log.info(String.format("write over! cost:%sms", (t2 - t1)));
        return CommonResult.success(null);
    }

    /**
     * 导入物品信息
     *
     * @param file
     */
    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public void readExcel(@RequestParam(value = "uploadFile", required = false) MultipartFile file) {
        long t1 = System.currentTimeMillis();
        List<ProductExcelData> list = ExcelUtil.readExcel("", ProductExcelData.class, file);
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("read over! cost:%sms", (t2 - t1)));
    }
}