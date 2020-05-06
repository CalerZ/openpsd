package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.ResourceCategory;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.ResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 11:20
 * @description :
 */
@RestController
@Api(tags = "资源分类管理", description = "资源分类管理")
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加资源分类")
    public CommonResult create(@RequestBody  ResourceCategory resourceCategory){
        return CommonResult.success(resourceCategoryService.create(resourceCategory)==1?true:false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改资源分类")
    public CommonResult update(@RequestBody  ResourceCategory resourceCategory){
        return CommonResult.success(resourceCategoryService.update(resourceCategory)==1?true:false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除资源分类")
    public CommonResult delete(@PathVariable(value = "id",required = true)  Long id){
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        return CommonResult.success(resourceCategoryService.delete(ids)>0?true:false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个资源分类")
    public CommonResult list(@PathVariable(value = "id",required = true) Long id){
        ResourceCategory resourceCategory = resourceCategoryService.list(id);
        return CommonResult.success(resourceCategory);
    }


    /**
     * 查询所有
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有资源分类")
    public CommonResult list(){
        List<ResourceCategory> list = resourceCategoryService.list();
        return CommonResult.success(list);
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有用户")
    public CommonResult list(@RequestParam(value = "keyword",required = false) String keyword,
                             @RequestParam(value = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum",required = true,defaultValue = "1") Integer pageNum){
        List<ResourceCategory> list = resourceCategoryService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

}
