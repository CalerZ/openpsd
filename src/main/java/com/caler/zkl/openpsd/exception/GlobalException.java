package com.caler.zkl.openpsd.exception;

import com.caler.zkl.openpsd.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 13:49
 * @description :
 */
@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public CommonResult bizExceptionHandler(HttpServletRequest req, BizException e){
        log.error("发生业务异常！原因是：{}",e.getMessage());
        return CommonResult.failed("发生业务异常！原因是： "+e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public CommonResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return CommonResult.failed("发生空指针异常！原因是: "+e.getMessage());
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public CommonResult exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return CommonResult.failed("未知异常！原因是: "+e.getMessage());
    }

}
