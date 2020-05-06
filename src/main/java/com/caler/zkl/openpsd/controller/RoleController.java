package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Member;
import com.caler.zkl.openpsd.bean.Role;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.RoleService;
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
@Api(tags = "角色管理", description = "角色管理")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加角色")
    public CommonResult create(@RequestBody Role role) {
        return CommonResult.success(roleService.create(role) == 1 ? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改角色")
    public CommonResult update(@RequestBody Role role) {
        return CommonResult.success(roleService.update(role) == 1 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除角色")
    public CommonResult delete(@PathVariable(value = "id", required = true) Long id) {
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        return CommonResult.success(roleService.delete(ids) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list/{id}")
    @ApiOperation("查询单个角色")
    public CommonResult list(@PathVariable(value = "id", required = true) Long id) {
        Role role = roleService.list(id);
        return CommonResult.success(role);
    }


    /**
     * 查询所有
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有角色")
    public CommonResult list() {
        List<Role> list = roleService.list();
        return CommonResult.success(list);
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有用户")
    public CommonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<Role> list = roleService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询角色")
    public CommonResult list(@RequestBody Role role,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<Role> roleList = roleService.list(role, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));

    }

    /**
     * 给角色分配资源
     */
    @PostMapping("/listResource/{id}")
    @ApiOperation("角色中添加资源")
    public CommonResult getListResource(@PathVariable("id") Long id) {
        return CommonResult.success(roleService.getListResourceById(id));
    }

    /**
     * 给角色分配资源
     */
    @PostMapping("/allocResource")
    @ApiOperation("角色中添加资源")
    public CommonResult allocResource(@RequestParam("roleId") Long roleId, @RequestParam("resourceIds") List<Long> resourceIds) {
        return CommonResult.success(roleService.allocResource(roleId, resourceIds) > 0);
    }

    /**
     * 获取角色的菜单
     */
    @PostMapping("/listMenu/{id}")
    @ApiOperation("获取角色的菜单")
    public CommonResult listMenu(@PathVariable("id") Long id) {
        return CommonResult.success(roleService.listMenu(id));
    }

    /**
     * 获取角色的菜单
     */
    @PostMapping("/allocMenu")
    @ApiOperation("获取角色的菜单")
    public CommonResult allocMenu(@RequestParam("roleId") Long roleId,
                                  @RequestParam("menuIds") List<Long> menuIds) {
        return CommonResult.success(roleService.allocMenu(roleId, menuIds) > 0);
    }


}
