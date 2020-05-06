package com.caler.zkl.openpsd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Caler_赵康乐
 * @create 2020-05-05 18:09
 * @description :
 */
@Controller
@RequestMapping("/sys")
public class SystemMonitorController {

    /**
     * 访问api文档链接
     *
     * @return
     */
    @GetMapping("/apiDoc")
    public String apiDoc() {
        return "/apiDoc";
    }

    /**
     * 访问api文档链接
     *
     * @return
     */
    @GetMapping("/dataBase")
    public String dataBase() {
        return "/dataBase";
    }
}
