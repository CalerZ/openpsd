package com.caler.zkl.openpsd.controller;

import com.caler.zkl.openpsd.bean.Member;
import com.caler.zkl.openpsd.bean.MemberLevel;
import com.caler.zkl.openpsd.bean.Role;
import com.caler.zkl.openpsd.common.CommonPage;
import com.caler.zkl.openpsd.common.CommonResult;
import com.caler.zkl.openpsd.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 11:20
 * @description :用户的增删改查等
 */
@RestController
@Api(tags = "用户管理", description = "用户管理")
    @RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 添加(用户添加)
     */
    @PostMapping("/insert")
    @ApiOperation("添加用户")
    public CommonResult create(@RequestBody  Member member){
        return CommonResult.success(memberService.create(member)==1?true:false);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改用户")
    public CommonResult update(@RequestBody  Member member){
        return CommonResult.success(memberService.update(member)==1?true:false);
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("批量删除用户")
    public CommonResult delete(@PathVariable(value = "id",required = true) Long id){
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        return CommonResult.success(memberService.delete(ids)>0?true:false);
    }


    /**
     * 查询所有
     */
    @GetMapping("/list/{id}")
    @ApiOperation("查询单个用户")
    public CommonResult list(@PathVariable(value = "id") Long id){
        Member member = memberService.list(id);
        return CommonResult.success(member);
    }


    /**
     * 查询所有
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有用户")
    public CommonResult list(){
        List<Member> list = memberService.list();
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
        List<Member> list = memberService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


    /**
     * 查询所有
     */
    @GetMapping("/checkName")
    @ApiOperation("查询所有用户")
    public CommonResult list(@RequestParam(value = "username",required = true) String username){
        Boolean byName = memberService.checkByName(username);
        return CommonResult.success(byName);
    }


    /**
     * 条件分页查询
     */
    @PostMapping("/list")
    @ApiOperation("查询条件查询用户")
    public CommonResult list(@RequestBody Member member,
                             @RequestParam(value = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "pageNum",required = true,defaultValue = "1") Integer pageNum){
        List<Member> memberList = memberService.list(member, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(memberList));

    }

    /**
     * 给用户添加角色
     */
    @PostMapping("/role/update")
    @ApiOperation("角色中添加用户/权限")
    public CommonResult allocRole(@RequestParam("memberId") Long memberId,
                                  @RequestParam("roleIds") List<Long> roleIds){
        return CommonResult.success(memberService.allocRole(memberId,roleIds)==1?true:false);
    }

    /**
     * 给用户添加角色
     */
    @GetMapping("/role/{id}")
    @ApiOperation("角色中添加用户/权限")
    public CommonResult getRoleByMemberId(@PathVariable("id") Long memberId){
        return CommonResult.success(memberService.getRoleByMemberId(memberId));
    }

}
