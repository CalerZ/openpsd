package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.ErrorMsg;
import com.caler.zkl.openpsd.bean.ErrorMsgExample;
import com.caler.zkl.openpsd.mapper.ErrorMsgMapper;
import com.caler.zkl.openpsd.service.ErrorMsgService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class ErrorMsgServiceImpl implements ErrorMsgService {

    @Autowired
    private ErrorMsgMapper errorMsgMapper;

    @Override
    public int create(ErrorMsg errorMsg) {
        return errorMsgMapper.insertSelective(errorMsg);
    }

  
}
