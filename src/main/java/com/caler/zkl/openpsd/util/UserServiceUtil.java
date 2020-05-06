package com.caler.zkl.openpsd.util;

import com.caler.zkl.openpsd.bean.User;
import com.caler.zkl.openpsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author Caler_赵康乐
 * @create 2020-04-28 11:01
 * @description :
 */
@Component
public class UserServiceUtil {


    @Autowired
    private  UserService userService;

    /**
     * 获取登录人姓名
     *
     * @return
     */
    @ConditionalOnBean(SecurityContext.class)
    public String getUserName() {
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
    @ConditionalOnBean(SecurityContext.class)
    public  User getUser() {
        return userService.selectByName(getUserName());

    }
}
