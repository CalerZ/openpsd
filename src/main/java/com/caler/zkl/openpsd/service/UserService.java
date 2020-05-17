package com.caler.zkl.openpsd.service;

import com.caler.zkl.openpsd.bean.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Caler_赵康乐
 * @create 2020-04-27 12:54
 * @description :
 */
public interface UserService  extends UserDetailsService {
    String login(String username, String password);

    String refreshToken(String token);

    User selectByName(String username);
    User selectUserByName(String username);
}
