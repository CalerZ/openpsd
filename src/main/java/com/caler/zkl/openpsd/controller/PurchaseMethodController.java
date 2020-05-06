package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.PurchaseMethod;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.PurchaseMethodService;
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
@Api(tags = "采购方式管理", description = "采购方式管理")
@RequestMapping("/purchase")
public class PurchaseMethodController {

    @Autowired
    private PurchaseMethodService purchaseMethodService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加采购方式")
    public CommonResult create(@RequestBody PurchaseMethod purchaseMethod) {
        return CommonResult.success(purchaseMethodService.create(purchaseMethod)> 0? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改采购方式")
    public CommonResult update(@RequestBody PurchaseMethod purchaseMethod) {
        return CommonResult.success(purchaseMethodService.update(purchaseMethod)> 0? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除采购方式")
    public CommonResult delete(@RequestBody List<Long> ids) {
        return CommonResult.success(purchaseMethodService.delete(ids) > 0 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除采购方式")
    public CommonResult delete(@PathVariable("id") Long id) {
        return CommonResult.success(purchaseMethodService.delete(id) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个采购方式")
    public CommonResult list(@PathVariable("id") Long id) {
        PurchaseMethod purchaseMethod = purchaseMethodService.list(id);
        return CommonResult.success(purchaseMethod);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有采购方式")
    public CommonResult list() {
        List<PurchaseMethod> list = purchaseMethodService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询采购方式")
    public CommonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<PurchaseMethod> purchaseMethodList = purchaseMethodService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(purchaseMethodList));

    }

}
