package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.MenuNode;
import com.caler.zkl.openpsd.bean.ProductType;
import com.caler.zkl.openpsd.bean.ProductTypeNode;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.ProductTypeService;
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
@Api(tags = "物品类型管理", description = "物品类型管理")
@RequestMapping("/ptype")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加物品类型")
    public CommonResult create(@RequestBody ProductType productType) {
        return CommonResult.success(productTypeService.create(productType) == 1 ? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改物品类型")
    public CommonResult update(@RequestBody ProductType productType) {
        return CommonResult.success(productTypeService.update(productType) == 1 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除物品类型")
    public CommonResult delete(@RequestBody List<Long> ids) {
        return CommonResult.success(productTypeService.delete(ids) > 0 ? true : false);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除物品类型")
    public CommonResult delete(@PathVariable(value = "id") Long id) {
        return CommonResult.success(productTypeService.delete(id) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个物品类型")
    public CommonResult list(@PathVariable("id") Long id) {
        ProductType productType = productTypeService.list(id);
        return CommonResult.success(productType);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有物品类型")
    public CommonResult list() {
        List<ProductType> list = productTypeService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list/{pid}")
    @ApiOperation("查询条件查询物品类型")
    public CommonResult list(@PathVariable(value = "pid", required = true) Long pid,
                             @RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<ProductType> productTypeList = productTypeService.list(pid, keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productTypeList));

    }

    /**
     * 查询所有
     */
    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProductTypeNode>> treeList() {
        List<ProductTypeNode> list = productTypeService.treeList();
        return CommonResult.success(list);
    }

}
