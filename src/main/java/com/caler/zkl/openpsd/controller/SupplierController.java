package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Supplier;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 11:20
 * @description :
 */
@RestController
@Api(tags = "供应商管理", description = "供应商管理")
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加供应商")
    public CommonResult create(@RequestBody Supplier supplier) {
        return CommonResult.success(supplierService.create(supplier)> 0? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改供应商")
    public CommonResult update(@RequestBody Supplier supplier) {
        return CommonResult.success(supplierService.update(supplier)> 0? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除供应商")
    public CommonResult delete(@RequestBody List<Long> ids) {
        return CommonResult.success(supplierService.delete(ids) > 0 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除供应商")
    public CommonResult delete(@PathVariable("id") Long id) {
        return CommonResult.success(supplierService.delete(id) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个供应商")
    public CommonResult list(@PathVariable("id") Long id) {
        Supplier supplier = supplierService.list(id);
        return CommonResult.success(supplier);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有供应商")
    public CommonResult list() {
        List<Supplier> list = supplierService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询条件查询供应商")
    public CommonResult list(@RequestParam(value = "keyword",required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum, HttpServletRequest request) {
        List<Supplier> supplierList = supplierService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(supplierList));

    }

}
