package com.caler.zkl.openpsd.controller;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import com.caler.zkl.openpsd.bean.ExcelData;
import com.caler.zkl.openpsd.bean.ExcelImportResult;
import com.caler.zkl.openpsd.bean.Product;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.common.ProductExcelData;
import com.caler.zkl.openpsd.mapper.ApplicationFormDao;
import com.caler.zkl.openpsd.mapper.ProductDao;
import com.caler.zkl.openpsd.mapper.ProductMapper;
import com.caler.zkl.openpsd.service.ApplicationService;
import com.caler.zkl.openpsd.service.ExcelDataService;
import com.caler.zkl.openpsd.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@Api(tags = "信息管理", description = "信息管理")
@RequestMapping("/info")
public class ExcelOperationController {
    private static final Logger log = LogManager.getLogger(ExcelOperationController.class);


    @Autowired
    private com.caler.zkl.openpsd.service.ApplicationService applicationService;

    @Autowired
    private ExcelDataService excelDataService;

    /**
     * 导出excel
     *
     * @param response
     * @throws IOException
     */
    @PostMapping("/exportExcel")
    @ApiOperation("导出物料信息")
    public CommonResult exportExcel(
            @RequestParam(value = "quarter", required = false) String quarter,
            @RequestParam(value = "date[]", required = false) String[] date,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            HttpServletResponse response) throws IOException {

        //根据id去查询分类
        Map<String, List<ProductExcelData>> map = new HashMap<>();
        List<ProductExcelData> productExcelDatas = applicationService.getExcelData(date, quarter, year);
        productExcelDatas.forEach(item -> {
            if (!map.containsKey(item.getType())) {
                List<ProductExcelData> list = new ArrayList<>();
                item.setNoid(1 + "");
                list.add(item);
                map.put(item.getType(), list);
            } else {
                List<ProductExcelData> list = map.get(item.getType());
                item.setNoid(list.size() + 1 + "");
                list.add(item);
                map.put(item.getType(), list);
            }
        });

        long t1 = System.currentTimeMillis();
        ExcelUtil.writeExcel(response, map, ProductExcelData.class);
        long t2 = System.currentTimeMillis();
        log.info(String.format("write over! cost:%sms", (t2 - t1)));
        return CommonResult.success("物料信息导出.xlsx");
    }

    /**
     * 导入物品信息
     *
     * @param file
     */
    @ApiOperation("导入物料信息")
    @PostMapping("/readExcel")
    @ResponseBody
    public CommonResult readExcel(@RequestParam(value = "uploadFile", required = false) MultipartFile file) {
        List<ExcelImportResult> excelImportResults = excelDataService.importProduct(file);
        return CommonResult.success(CommonPage.restPage(excelImportResults));
    }


    /**
     * 下载模板
     */
    @ApiOperation("下载模板")
    @RequestMapping(value = "/downTemplate", method = RequestMethod.GET)
    public void downTemplate(HttpServletRequest request, HttpServletResponse response) {
        BufferedInputStream input = null;
        ServletOutputStream output = null;
        try {
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("物料导入模板.xlsx", "UTF-8"));
            // 设置下载文件的mineType，告诉浏览器下载文件类型
            String mineType = request.getServletContext().getMimeType("物料导入模板.xlsx");
            response.setContentType(mineType);
            input = new BufferedInputStream(ExcelOperationController.class.getResourceAsStream("/static/物料导入模板.xlsx"));
            output = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = input.read(bytes)) != -1) {
                output.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}