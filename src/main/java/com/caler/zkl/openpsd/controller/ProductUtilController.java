package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.ProductUtil;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.ProductUtilService;
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
@Api(tags = "物品单位管理", description = "物品单位管理")
@RequestMapping("/putil")
public class ProductUtilController {

    @Autowired
    private ProductUtilService memberService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加物品单位")
    public CommonResult create(@RequestBody ProductUtil member) {
        return CommonResult.success(memberService.create(member) >0 ? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改物品单位")
    public CommonResult update(@RequestBody ProductUtil member) {
        return CommonResult.success(memberService.update(member) >0 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除物品单位")
    public CommonResult delete(@RequestBody List<Long> ids) {
        return CommonResult.success(memberService.delete(ids) > 0 ? true : false);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除物品单位")
    public CommonResult delete(@PathVariable("id") Long id) {
        return CommonResult.success(memberService.delete(id) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个物品单位")
    public CommonResult list(@PathVariable("id") Long id) {
        ProductUtil member = memberService.list(id);
        return CommonResult.success(member);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询状态为显示的物品单位")
    public CommonResult list() {
        List<ProductUtil> list = memberService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询物品单位")
    public CommonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<ProductUtil> memberList = memberService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(memberList));

    }

    /**
     * 修改状态
     */
    @PostMapping("/updateStatus")
    @ApiOperation("修改物品单位状态")
    public CommonResult updateStatus(@RequestParam(value = "id", required = false) Long id,
                               @RequestParam(value = "status", required = false) Integer status) {
        return CommonResult.success(memberService.updateStatus(id,status) >0 ? true : false);
    }

    /**
     * 批量修改状态
     */
    @PostMapping("/updateStatus/{status}")
    @ApiOperation("修改物品单位状态")
    public CommonResult updateStatus(@PathVariable(value = "status", required = true) Integer status,
                                     @RequestBody List<Long>  ids) {
        return CommonResult.success(memberService.updateStatus(ids,status) >0 ? true : false);
    }


    /**
     * 批量封存
     */
    @PostMapping("/sealed")
    @ApiOperation("修改物品单位状态")
    public CommonResult sealed(@RequestBody List<Long>  ids) {
        return CommonResult.success(memberService.sealed(ids) >0 ? true : false);
    }

}
