package com.caler.zkl.openpsd.comp;

import com.caler.zkl.openpsd.util.LoggingUtil;
import com.caler.zkl.openpsd.util.UserServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Caler_赵康乐
 * @create 2020-04-27 17:25
 * @description :
 */
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // AuthenticationException 认证过程中产生的异常
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.info("MyAuthenticationSuccessHandler login failure!");
        LoggingUtil loggingUtil = new LoggingUtil();
        UserServiceUtil userServiceUtil = new UserServiceUtil();
        loggingUtil.writeLog("202", userServiceUtil.getUserName()+"用户登录失败:"+ exception.getMessage());
        super.onAuthenticationFailure(request, response, exception);

    }

}
