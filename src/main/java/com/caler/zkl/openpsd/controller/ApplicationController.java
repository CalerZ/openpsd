package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Application;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CommonResult create(@RequestBody Application application) {
        return CommonResult.success(applicationService.create(application) > 0 ? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/submit")
    @ApiOperation("提交物品申请单")
    public CommonResult submit(@RequestBody Application application) {
        return CommonResult.success(applicationService.submit(application) > 0 ? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改物品申请单")
    public CommonResult update(@RequestBody Application application) {
        return CommonResult.success(applicationService.update(application) > 0 ? true : false);
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
        Application application = applicationService.list(id);
        return CommonResult.success(application);
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
    @ApiOperation("查询条件查询物品申请单")
    public CommonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<Application> applicationList = applicationService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(applicationList));

    }

    /**
     * 我提交的申请单
     */
    @PostMapping("/myApplicationList")
    @ApiOperation("查询条件查询物品申请单")
    public CommonResult myApplicationList(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<Application> applicationList = applicationService.myApplicationList(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(applicationList));

    }

    /**
     * 待审核列表
     */
    @PostMapping("/reviewedApplicationList")
    @ApiOperation("查询条件查询物品申请单")
    public CommonResult reviewedApplicationList(@RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<Application> applicationList = applicationService.reviewedApplicationList(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(applicationList));

    }

    /**
     * 生成申请单单号
     */
    @PostMapping("/applyFormNo")
    @ApiOperation("生成申请单单号")
    public CommonResult getFormNo(){
        String formNo = applicationService.generateFormNo();
        return CommonResult.success(formNo);

    }

}
