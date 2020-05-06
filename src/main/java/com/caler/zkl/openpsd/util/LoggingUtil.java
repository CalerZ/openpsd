package com.caler.zkl.openpsd.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.RuntimeUtil;
import com.caler.zkl.openpsd.bean.ErrorMsg;
import com.caler.zkl.openpsd.service.ErrorMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 15:31
 * @description :
 */
@Component
public class LoggingUtil {

    @Autowired
    private ErrorMsgService errorMsgService;

    @Async
    public   void writeLog(String code ,String message){
        ErrorMsg errorMsg = new ErrorMsg();
        errorMsg.setCode(code);
        errorMsg.setText(message);
        errorMsg.setTime(DateUtil.now());
        errorMsg.setIp(NetUtil.getLocalhost().getHostAddress());
        errorMsgService.create(errorMsg);
    }
}
