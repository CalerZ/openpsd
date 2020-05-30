package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.bean.ExportProductData;
import com.caler.zkl.openpsd.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 11:20
 * @description :
 */
@RestController
@Api(tags = "物品申请单管理", description = "物品申请单管理")
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("保存物品申请单")
    public CommonResult create(@RequestBody ApplicationProductPoJo applicationProductPoJo) {
        Application application = new Application();
        convertObj(applicationProductPoJo, application,"");
        return CommonResult.success(applicationService.create(application) > 0 ? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/submit")
    @ApiOperation("提交物品申请单")
    public CommonResult submit(@RequestBody ApplicationProductPoJo applicationProductPoJo) {
        Application application = new Application();
        convertObj(applicationProductPoJo, application,"");
        return CommonResult.success(applicationService.submit(application) > 0 ? true : false);
    }

    /**
     * 完成:修改状态为2
     */
    @PostMapping("/finish")
    @ApiOperation("完成物品申请单")
    public CommonResult finish(@RequestBody ApplicationProductPoJo applicationProductPoJo) {
        Application application = new Application();
        convertObj(applicationProductPoJo, application,"finish");
        return CommonResult.success(applicationService.finish(application) > 0 ? true : false);
    }

    /**
     * 取消：修改状态为0
     */
    @PostMapping("/cancel/{id}")
    @ApiOperation("撤销物品申请单")
    public CommonResult cancel(@PathVariable("id") Long id) {
        return CommonResult.success(applicationService.cancel(id) > 0 ? true : false);
    }


    /**
     * 修改  修改当前申请单
     */
    @PostMapping("/update")
    @ApiOperation("修改物品申请单")
    public CommonResult update(@RequestBody ApplicationProductPoJo applicationProductPoJo) {
        Application application = new Application();
        convertObj(applicationProductPoJo, application,"");
        return CommonResult.success(applicationService.update(application) > 0 ? true : false);
    }

    /**
     * 批量修改提交申请：修改状态为1
     */
    @PostMapping("/updateStatus")
    @ApiOperation("批量修改状态")
    public CommonResult updateStatus(@RequestBody List<Long> ids) {
        return CommonResult.success(applicationService.updateStatus(ids) > 0 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除物品申请单")
    public CommonResult delete(@RequestBody List<Long> ids) {
        return CommonResult.success(applicationService.delete(ids) > 0 ? true : false);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除物品申请单")
    public CommonResult delete(@PathVariable("id") Long id) {
        return CommonResult.success(applicationService.delete(id) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个物品申请单")
    public CommonResult list(@PathVariable("id") Long id) {
        ApplicationProductPoJo applicationBean = applicationService.list(id);
        return CommonResult.success(applicationBean);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有物品申请单")
    public CommonResult list() {
        List<Application> list = applicationService.list();
        return CommonResult.success(list);
    }


    /**
     * 查询所有的申请单
     */
    @PostMapping("/list")
    @ApiOperation("查询所有的申请单")
    public CommonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<ApplicationFormBean> applicationList = applicationService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(applicationList));

    }

    /**
     * 我提交的申请单
     */
    @PostMapping("/myApplicationList")
    @ApiOperation("我提交的申请单")
    public CommonResult myApplicationList(@RequestParam(value = "keyword", required = false) String keyword,
                                          @RequestParam(value = "status", required = false) Integer status,
                                          @RequestParam(value = "date1", required = false) String date1,
                                          @RequestParam(value = "date2", required = false) String date2,
                                          @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {

        List<ApplicationFormBean> applicationPageInfo = applicationService.myApplicationList(keyword,status,date1,date2,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(applicationPageInfo));

    }

    /**
     * 待审核列表
     */
    @PostMapping("/reviewedApplicationList")
    @ApiOperation("待审核列表")
    public CommonResult reviewedApplicationList(@RequestParam(value = "keyword", required = false) String keyword,
                                                @RequestParam(value = "applyUser", required = false) String applyUser,
                                                @RequestParam(value = "date1", required = false) String date1,
                                                @RequestParam(value = "date2", required = false) String date2,
                                                @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                                                @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<ApplicationFormBean> applicationPageInfo = applicationService.reviewedApplicationList(keyword,applyUser,date1,date2, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(applicationPageInfo));

    }

    /**
     * 审核记录列表
     */
    @PostMapping("/finishApplicationList")
    @ApiOperation("查询审核通过记录列表")
    public CommonResult finishApplicationList(@RequestParam(value = "keyword", required = false) String keyword,
                                              @RequestParam(value = "applyUser", required = false) String applyUser,
                                              @RequestParam(value = "date1", required = false) String date1,
                                              @RequestParam(value = "date2", required = false) String date2,
                                              @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<ApplicationFormBean> applicationPageInfo = applicationService.finishApplicationList(keyword,applyUser,date1,date2, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(applicationPageInfo));

    }


    /**
     * 生成申请单单号
     */
    @PostMapping("/applyFormNo")
    @ApiOperation("生成申请单单号")
    public CommonResult getFormNo() {
        String formNo = applicationService.generateFormNo();
        return CommonResult.success(formNo);

    }


    /**
     * 查询导出物料列表
     */
    @PostMapping("/selectExcelData")
    @ApiOperation("查询导出物品列表")
    public CommonResult select(@RequestParam(value = "quarter", required = false) String quarter,
                               @RequestParam(value = "date1", required = false) String date1,
                               @RequestParam(value = "date2", required = false) String date2,
                               @RequestParam(value = "year", required = false) String year,
                               @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {

        List<ExportProductData> exportProductData = applicationService.getExcelDataList(date1,date2, quarter, year, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(exportProductData));


    }


    public void convertObj(ApplicationProductPoJo applicationProductPoJo, Application application, String type) {
        application.setApplicationForm(applicationProductPoJo.getApplicationForm());
        AtomicInteger count = new AtomicInteger();
        List<ApplicationProduct> applicationProducts = applicationProductPoJo.getApplicationProducts().stream().map(item -> {
            ApplicationProduct applicationProduct = new ApplicationProduct();
            if(item.getProductId()==null){//创建
//                创建的时候把物料的id给productid
                applicationProduct.setProductId(item.getId());
            }else{//修改
                applicationProduct.setId(item.getId());
                applicationProduct.setProductId(item.getProductId());
            }
            applicationProduct.setProductName(item.getName());
            applicationProduct.setProductCode(item.getCode());

            applicationProduct.setType1(item.getProductType1().getId());
            if(item.getProductType2()!=null){
                applicationProduct.setType2(item.getProductType2().getId());
            }
            applicationProduct.setDescription(item.getDescription());
            applicationProduct.setSpecifications(item.getSpecifications());
            applicationProduct.setUnit(item.getProductUtil().getId());
            applicationProduct.setPrice(item.getPrice());
            applicationProduct.setStandard(item.getStandard());
            applicationProduct.setSafetyStock(item.getStock().getSafetyStock());
            applicationProduct.setLastMonthQuantity(item.getStock().getLastMonthQuantity());
            applicationProduct.setOnHandInventory(item.getStock().getOnHandInventory());
            applicationProduct.setReportedQuantity(item.getStock().getReportedQuantity());
            applicationProduct.setSort(count.getAndIncrement());
            applicationProduct.setNote(null);
            applicationProduct.setStatus(item.getStatus());
            applicationProduct.setIsDelete(item.getIsDelete());
            applicationProduct.setProdLineMembers(item.getStock().getProdLineMembers());
            applicationProduct.setPurchaseMethod(item.getPurchaseMethod().getId());
            if ("finish".equals(type)){
                applicationProduct.setSupplierId(Long.valueOf(item.getSupplierId()));
            }else{
                applicationProduct.setSupplierId(null);
            }
            return applicationProduct;
        }).collect(Collectors.toList());
        application.setApplicationProducts(applicationProducts);
    }

}
