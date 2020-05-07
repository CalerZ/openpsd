package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.SysDict;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.SysDictService;
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
@Api(tags = "字典表管理", description = "字典表管理")
@RequestMapping("/sysDict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加SysDict")
    public CommonResult create(@RequestBody SysDict sysDict) {
        return CommonResult.success(sysDictService.create(sysDict)> 0? true : false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改SysDict")
    public CommonResult update(@RequestBody SysDict sysDict) {
        return CommonResult.success(sysDictService.update(sysDict)> 0? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除SysDict")
    public CommonResult delete(@RequestBody List<Long> ids) {
        return CommonResult.success(sysDictService.delete(ids) > 0 ? true : false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除SysDict")
    public CommonResult delete(@PathVariable("id") Long id) {
        return CommonResult.success(sysDictService.delete(id) > 0 ? true : false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个SysDict")
    public CommonResult list(@PathVariable("id") Long id) {
        SysDict sysDict = sysDictService.list(id);
        return CommonResult.success(sysDict);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有SysDict")
    public CommonResult list() {
        List<SysDict> list = sysDictService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询SysDict")
    public CommonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum) {
        List<SysDict> sysDictList = sysDictService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(sysDictList));

    }

}
