package com.caler.zkl.openpsd.aop;

/**
 * @author Caler_赵康乐
 * @create 2020-04-29 14:27
 * @description :
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 当resource进行变更时，人员携带的resource资源需要重新加载
 */
@Configuration
@Aspect
public class ControllerAOP {

    @Around("execution (* com.caler.zkl.openpsd.controller.*.*(..))")
    public Object testAop(ProceedingJoinPoint pro) throws Throwable {

        //获取response
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //执行调用的方法
        Object proceed = pro.proceed();
        return proceed;
    }


}
