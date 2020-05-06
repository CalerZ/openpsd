package com.caler.zkl.openpsd.anno;

import java.lang.annotation.*;

/**
 * @author Caler_赵康乐
 * @create 2020-04-29 8:56
 * @description :
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    /**
     * Excel标题
     *
     * @return
     * @author Lynch
     */
    String value() default "";

    /**
     * Excel从左往右排列位置
     *
     * @return
     * @author Lynch
     */
    int col() default 0;
}
