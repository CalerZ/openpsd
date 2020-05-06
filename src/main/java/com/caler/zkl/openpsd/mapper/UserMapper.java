package com.caler.zkl.openpsd.mapper;


import com.caler.zkl.openpsd.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Caler_赵康乐
 * @create 2020-05-01 20:26
 * @description :
 */
public interface UserMapper {
    User selectByName(@Param("username") String username);
}
