package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.comp.DynamicSecurityMetadataSource;
import com.caler.zkl.openpsd.service.ResourceService;
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
@Api(tags = "资源管理", description = "资源管理")
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加资源")
    public CommonResult create(@RequestBody Resource resource) {
        if (dynamicSecurityMetadataSource!=null) {
            dynamicSecurityMetadataSource.clearDataSource();
        }
        return CommonResult.success(resourceService.create(resource) == 1 ? true : false);

    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改资源")
    public CommonResult update(@RequestBody Resource resource) {
        if (dynamicSecurityMetadataSource!=null) {
            dynamicSecurityMetadataSource.clearDataSource();
        }
        return CommonResult.success(resourceService.update(resource) == 1 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除资源")
    public CommonResult delete(@PathVariable(value = "id", required = true) Long id) {
        if (dynamicSecurityMetadataSource!=null) {
            dynamicSecurityMetadataSource.clearDataSource();
        }
        return CommonResult.success(resourceService.delete(id) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个资源")
    public CommonResult list(@PathVariable(value = "id", required = true) Long id) {
        Resource resource = resourceService.list(id);
        return CommonResult.success(resource);
    }


    /**
     * 查询所有
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有资源")
    public CommonResult list() {
        List<Resource> list = resourceService.list();
        return CommonResult.success(list);
    }

    /**
     * 查询所有
     */
    @PostMapping("/list")
    @ApiOperation("关键字查询所有资源")
    public CommonResult list(@RequestParam(value = "nameKeyword", required = false) String nameKeyword,
                             @RequestParam(value = "urlKeyword", required = false) String urlKeyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<Resource> list = resourceService.list(nameKeyword,urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


}
