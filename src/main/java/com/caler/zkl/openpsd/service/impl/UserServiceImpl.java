package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.*;
import com.caler.zkl.openpsd.service.*;
import com.caler.zkl.openpsd.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Caler_赵康乐
 * @create 2020-04-27 12:55
 * @description :
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberLoginLogMapper memberLoginLogMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.caler.zkl.openpsd.bean.User user = userMapper.selectByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<String> ps = new ArrayList<>();
        List<Resource> resources = user.getResources();
        for (Resource resource : resources) {
            ps.add(resource.getId() + ":" + resource.getName());
        }
        String[] arr = new String[ps.size()];
        ps.toArray(arr);
        UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(arr).build();
        return userDetails;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            updateLastLoginTime(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    @Override
    public com.caler.zkl.openpsd.bean.User selectByName(String username) {
        if (username == null || "".equals(username)) {
            throw new BadCredentialsException("用户名为空");
        }
        com.caler.zkl.openpsd.bean.User user = new com.caler.zkl.openpsd.bean.User();
        if ("admin".equals(username)) {//admin管理员拥有所有角色，菜单，资源，权限
            user = userMapper.selectByName(username);
            user.setRoles(roleService.list());
            user.setMenues(menuService.list());
            user.setResources(resourceService.list());
            user.setPermissions(permissionService.list());
        } else {
            user = userMapper.selectByName(username);
        }
        return user;
    }

    @Override
    public com.caler.zkl.openpsd.bean.User selectUserByName(String username) {
        if (username == null || "".equals(username)) {
            throw new BadCredentialsException("用户名为空");
        }
        com.caler.zkl.openpsd.bean.User user = new com.caler.zkl.openpsd.bean.User();
        user = userMapper.selectByName(username);
        return user;
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    @Async
    public void insertLoginLog(String username) {
        Member member = memberService.selectByName(username);
        if (member == null) return;
        //写入登录日志中
        MemberLoginLog memberLoginLog = new MemberLoginLog();
        memberLoginLog.setMemberId(member.getId());
        memberLoginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        memberLoginLog.setIp(request.getRemoteAddr());
        memberLoginLogMapper.insert(memberLoginLog);
    }

    @Async
    public void updateLastLoginTime(String username) {
        memberService.updateLastLoginTime(username);
    }


}
