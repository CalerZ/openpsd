package com.caler.zkl.openpsd.common;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 13:05
 * @description :
 */
@Slf4j
public class MyConvert  implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        Date result = null;
        try {
            //指定日期的格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //将源数据转为指定日期格式
            result = sdf.parse(s);
        } catch (ParseException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //返回转换后的时间格式日期
        return result;
    }



}
