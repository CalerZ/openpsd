package com.caler.zkl.openpsd.controller;

import java.io.IOException;
import java.util.*;

import cn.hutool.core.bean.BeanUtil;
import com.caler.zkl.openpsd.bean.ExcelData;
import com.caler.zkl.openpsd.bean.Product;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.common.ProductExcelData;
import com.caler.zkl.openpsd.mapper.ProductDao;
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
    private ProductDao productDao;

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
        Map<String, List<ProductExcelData>> map = new HashMap<>();
        List<ProductExcelData> productExcelDatas = productDao.getExcelData(ids);
        productExcelDatas.forEach(item->{
            if(!map.containsKey(item.getType())){
                List<ProductExcelData> list = new ArrayList<>();
                item.setNoid(1+"");
                list.add(item);
                map.put(item.getType(), list);
            }else{
                List<ProductExcelData> list = map.get(item.getType());
                item.setNoid(list.size()+1+"");
                list.add(item);
                map.put(item.getType(),list);
            }
        });

        long t1 = System.currentTimeMillis();
        ExcelUtil.writeExcel(response, map, ProductExcelData.class);
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