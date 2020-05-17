package com.caler.zkl.openpsd.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.caler.zkl.openpsd.mapper","com.caler.zkl.openpsd.dao"})
public class MyBatisConfig {
}
