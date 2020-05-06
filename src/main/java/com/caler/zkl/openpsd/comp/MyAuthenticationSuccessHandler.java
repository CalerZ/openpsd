package com.caler.zkl.openpsd.comp;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.caler.zkl.openpsd.bean.MemberLoginLog;
import com.caler.zkl.openpsd.service.LoginService;
import com.caler.zkl.openpsd.service.MemberService;
import com.caler.zkl.openpsd.util.SpringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Caler_赵康乐
 * @create 2020-04-27 17:22
 * @description :
 */
@Configuration
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    // Authentication  封装认证信息
    // 登录方式不同，Authentication不同
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        logger.info("MyAuthenticationSuccessHandler login success!");
        MemberService memberService = SpringUtil.getBean(MemberService.class);
        LoginService loginService = SpringUtil.getBean(LoginService.class);
        //写入登录日志中
        MemberLoginLog memberLoginLog = new MemberLoginLog();
        memberLoginLog.setCreateTime(new Date());
        memberLoginLog.setIp(request.getRemoteHost());
        memberLoginLog.setMemberId(memberService.selectByName(((UserDetails)authentication.getPrincipal()).getUsername()).getId());
        loginService.loginLog(memberLoginLog);
        response.sendRedirect("/success");
        super.onAuthenticationSuccess(request, response, authentication);

    }


}
