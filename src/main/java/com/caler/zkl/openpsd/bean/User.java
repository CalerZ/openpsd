package com.caler.zkl.openpsd.bean;

import com.caler.zkl.openpsd.bean.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Data
public class User extends Member {
    private Company company;
    private List<Role> roles;
    private List<Menu> menues;
    private List<Permission> permissions;
    private List<Resource> resources;

}
