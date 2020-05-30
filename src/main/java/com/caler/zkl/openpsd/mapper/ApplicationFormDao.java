package com.caler.zkl.openpsd.mapper;

import com.caler.zkl.openpsd.bean.ApplicationBean;
import com.caler.zkl.openpsd.bean.ApplicationFormBean;
import com.caler.zkl.openpsd.bean.ApplicationProductBean;
import com.caler.zkl.openpsd.bean.ExportProductData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-09 16:33
 * @description :
 */
public interface ApplicationFormDao {
    List<ApplicationFormBean> list(@Param("keyword") String keyword, @Param("status") Integer status, @Param("userid") Long userid);

    List<ApplicationFormBean> myApplicationList(@Param("keyword") String keyword,
                                                @Param("status") Integer status,
                                                @Param("date1") String date1,
                                                @Param("date2") String date2,
                                                @Param("userid") Long userid);

    List<ApplicationFormBean> reviewedApplicationList(@Param("keyword") String keyword,
                                                      @Param("applyUser") String  applyUser,
                                                      @Param("date1") String  date1,
                                                      @Param("date2") String  date2,
                                                      @Param("userid") Long userid);

    List<ApplicationFormBean> finishApplicationList(@Param("keyword") String keyword,
                                                    @Param("applyUser") String  applyUser,
                                                    @Param("date1") String  date1,
                                                    @Param("date2") String  date2,
                                                    @Param("userid") Long userid);

    List<ExportProductData> getExcelData(@Param("dateS") String dateS,
                                         @Param("dateE") String dateE,
                                         @Param("quarterS") String quarterS,
                                         @Param("quarterE") String quarterE,
                                         @Param("yearS") String yearS,
                                         @Param("yearE") String yearE);


    ApplicationBean selectOneApplication(@Param("id") Long id);

    List<ApplicationProductBean> selectFormProduct(@Param("id") Long id);

    ApplicationFormBean selectOneForm(@Param("id") Long id);


}
