package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Permission;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.PermissionService;
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
@Api(tags = "权限管理", description = "权限管理")
@RequestMapping("/premission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 添加
     */
    @PostMapping("/")
    @ApiOperation("添加权限")
    public CommonResult create(@RequestBody  Permission permission){
        return CommonResult.success(permissionService.create(permission)==1?true:false);
    }

    /**
     * 修改
     */
    @PutMapping("/")
    @ApiOperation("修改权限")
    public CommonResult update(@RequestBody  Permission permission){
        return CommonResult.success(permissionService.update(permission)==1?true:false);
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/")
    @ApiOperation("批量删除权限")
    public CommonResult delete(@RequestBody List<Long> ids){
        return CommonResult.success(permissionService.delete(ids)>0?true:false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list/{id}")
    @ApiOperation("查询单个权限")
    public CommonResult list(Long id){
        Permission permission = permissionService.list(id);
        return CommonResult.success(permission);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有权限")
    public CommonResult list(){
        List<Permission> list = permissionService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询权限")
    public CommonResult list(@RequestBody Permission permission,
                             @RequestParam(value = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum",required = true,defaultValue = "1") Integer pageNum){
        List<Permission> permissionList = permissionService.list(permission, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(permissionList));

    }

}
