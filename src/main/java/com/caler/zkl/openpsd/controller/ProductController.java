package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.ProductService;
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
@Api(tags = "物品管理", description = "物品管理")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService memberService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加物品")
    public CommonResult create(@RequestBody ProductDetail productDetail){
        return CommonResult.success(memberService.create(productDetail)>0?true:false);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("修改物品")
    public CommonResult update(@RequestBody  ProductDetail productDetail){
        return CommonResult.success(memberService.update(productDetail)>0?true:false);
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("批量删除物品")
    public CommonResult delete(@RequestBody List<Long> ids){
        return CommonResult.success(memberService.delete(ids)>0?true:false);
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除物品")
    public CommonResult delete(@PathVariable("id") Long id){
        return CommonResult.success(memberService.delete(id)>0?true:false);
    }



    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个物品")
    public CommonResult list(@PathVariable("id") Long id){
        ProductDetail productDetail = memberService.list(id);
        return CommonResult.success(productDetail);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有物品")
    public CommonResult list(){
        List<Product> list = memberService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询物品")
    public CommonResult list(@RequestParam(value = "keyword",required = false) String keyword,
                             @RequestParam(value = "typeid",required = false) Long typeid,
                             @RequestParam(value = "status",required = false) Integer status,
                             @RequestParam(value = "createrid",required = false) Long createrid,
                             @RequestParam(value = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum",required = true,defaultValue = "1") Integer pageNum){
        List<ProductBean> memberList = memberService.list(keyword,typeid,status,createrid, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(memberList));

    }

    /**
     * 条件分页查询
     */
    @PostMapping("/releaseList")
    @ApiOperation("查询已发布的物品")
    public CommonResult list(@RequestParam(value = "keyword",required = false) String keyword,
                             @RequestParam(value = "typeid",required = false) Long typeid,
                             @RequestParam(value = "createrid",required = false) Long createrid,
                             @RequestParam(value = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum",required = true,defaultValue = "1") Integer pageNum){
        List<ProductBean> memberList = memberService.list(keyword,typeid,1,createrid, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(memberList));

    }



    /**
     * 查询所有
     */
    @GetMapping("/purchaseMethod")
    @ApiOperation("查询所有采购方式")
    public CommonResult purchaseMethodlist(){
        List<PurchaseMethod> list = memberService.purchaseMethodlist();
        return CommonResult.success(list);
    }

    /**
     * 查询所有
     */
    @PostMapping("/applicationProductList")
    @ApiOperation("查询所有物品封装为applicationProduct")
    public CommonResult applicationProductList(@RequestBody  List<Long> ids){
        List<ApplicationProduct> list = memberService.applicationProductList(ids);
        return CommonResult.success(list);
    }

    /**
     * 查询所有
     */
    @PostMapping("/productNo")
    @ApiOperation("获取物料编码")
    public CommonResult getProductNo(@RequestParam(value = "type1",required = true) Long type1,
                                     @RequestParam(value = "type2",required = true) Long type2){
        String productNo = memberService.getProductNo(type1,type2);
        return CommonResult.success(productNo);
    }


}
