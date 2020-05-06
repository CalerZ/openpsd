package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Menu;
import com.caler.zkl.openpsd.bean.MenuNode;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.MenuService;
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
@Api(tags = "菜单管理", description = "菜单管理")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加菜单")
    public CommonResult create(@RequestBody Menu menu) {
        return CommonResult.success(menuService.create(menu) == 1 ? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改菜单")
    public CommonResult update(@RequestBody Menu menu) {
        return CommonResult.success(menuService.update(menu) == 1 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除菜单")
    public CommonResult delete(@PathVariable(value = "id", required = true) Long id) {
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        return CommonResult.success(menuService.delete(ids) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个菜单")
    public CommonResult list(@PathVariable(value = "id", required = true) Long id) {
        Menu menu = menuService.list(id);
        return CommonResult.success(menu);
    }


    /**
     * 查询所有
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有菜单")
    public CommonResult list() {
        List<Menu> list = menuService.list();
        return CommonResult.success(list);
    }

    /**
     * 查询所有
     */
    @PostMapping("/list/{pid}")
    @ApiOperation("关键字查询所有菜单")
    public CommonResult list(@PathVariable(value = "pid", required = true) Long pid,
                             @RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<Menu> list = menuService.list(pid,keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MenuNode>> treeList() {
        List<MenuNode> list = menuService.treeList();
        return CommonResult.success(list);
    }


}
