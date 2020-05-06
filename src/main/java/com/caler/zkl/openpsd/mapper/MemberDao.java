package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.Menu;
import com.caler.zkl.openpsd.bean.Permission;
import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-01 19:52
 * @description :
 */
public interface MemberDao {
    List<Role> selectRoleByMemberId(@Param("id") Long id);
    List<Menu> selectMenuByMemberId(@Param("id") Long id);
    List<Permission> selectPermissionByMemberId(@Param("id") Long id);
    List<Resource> selectResourceByMemberId(@Param("id") Long id);


}
