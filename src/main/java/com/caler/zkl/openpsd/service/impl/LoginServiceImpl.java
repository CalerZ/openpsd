package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.MemberLoginLog;
import com.caler.zkl.openpsd.mapper.MemberLoginLogMapper;
import com.caler.zkl.openpsd.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Caler_赵康乐
 * @create 2020-04-27 17:43
 * @description :
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MemberLoginLogMapper memberLoginLogMapper;
    @Override
    public int loginLog(MemberLoginLog memberLoginLog) {
        return memberLoginLogMapper.insert(memberLoginLog);
    }
}
