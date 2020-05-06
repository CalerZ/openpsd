package com.caler.zkl.openpsd.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 10:33
 * @description :
 */
@Controller
public class Test {

    @GetMapping("/test")
    @ResponseBody
    public String test() {

        return "hello psd";
    }

    @PostMapping("/success")
    @ResponseBody
    public String success() {

        return getUserName()+" 登录成功啊success";
    }


    @GetMapping("/r/1")
    @ResponseBody
    public String s1() {

        return getUserName()+" s1资源";
    }

    @GetMapping("/r/2")
    @ResponseBody
    public String s2() {

        return getUserName()+" s2资源";
    }


    @GetMapping("login-view")
    public String loginView() {

        return "login";
    }


    /**
     * 获取登录人姓名
     * @return
     */
    private String getUserName() {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "";
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        return username;

    }

}
