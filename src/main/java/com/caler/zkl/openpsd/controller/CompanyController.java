package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Company;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.CompanyService;
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
@Api(tags = "公司管理", description = "公司管理")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 添加
     */
    @PostMapping("/insert")
    @ApiOperation("添加公司")
    public CommonResult create(@RequestBody  Company company){
        return CommonResult.success(companyService.create(company)==1?true:false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改公司")
    public CommonResult update(@RequestBody  Company company){
        return CommonResult.success(companyService.update(company)==1?true:false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除公司")
    public CommonResult delete(@RequestBody List<Long> ids){
        return CommonResult.success(companyService.delete(ids)>0?true:false);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除公司")
    public CommonResult delete(@PathVariable("id") Long id){
        return CommonResult.success(companyService.delete(id)>0?true:false);
    }


    /**
     * 单行记录查询
     */
    @GetMapping("/{id}")
    @ApiOperation("查询单个公司")
    public CommonResult list(@PathVariable("id") Long id){
        Company company = companyService.list(id);
        return CommonResult.success(company);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation("查询所有公司")
    public CommonResult list(){
        List<Company> list = companyService.list();
        return CommonResult.success(list);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询公司")
    public CommonResult list(@RequestParam(value = "keyword",required = false) String keyword,
                             @RequestParam(value = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum",required = true,defaultValue = "1") Integer pageNum){
        List<Company> companyList = companyService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(companyList));

    }

}
