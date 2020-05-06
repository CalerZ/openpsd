package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.Menu;
import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.bean.Role;
import com.caler.zkl.openpsd.bean.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleExtendMapper {

    List<Resource> selectResourceByRoleId(@Param("id") Long id);

    List<Menu>  selectMenuByRoleId(@Param("id") Long id);

}