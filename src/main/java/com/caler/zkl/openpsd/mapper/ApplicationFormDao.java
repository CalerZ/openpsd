package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.applicationFormBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-09 16:33
 * @description :
 */
public interface ApplicationFormDao {
    List<applicationFormBean> list(@Param("keyword") String keyword, @Param("status")Integer status, @Param("userid")Long userid);
    List<applicationFormBean> myApplicationList(@Param("keyword") String keyword, @Param("status")Integer status, @Param("userid")Long userid);
    List<applicationFormBean> reviewedApplicationList(@Param("keyword") String keyword, @Param("status")Integer status, @Param("userid")Long userid);
}
