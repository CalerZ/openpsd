package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.ErrorMsg;
import com.caler.zkl.openpsd.bean.Member;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface ErrorMsgService {
    /**
     * 添加
     */
    int create(ErrorMsg errorMsg);
}
