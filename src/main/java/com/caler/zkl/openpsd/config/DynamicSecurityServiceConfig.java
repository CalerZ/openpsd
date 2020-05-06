package com.caler.zkl.openpsd.config;

import com.caler.zkl.openpsd.bean.Resource;
import com.caler.zkl.openpsd.mapper.ResourceMapper;
import com.caler.zkl.openpsd.service.DynamicSecurityService;
import com.caler.zkl.openpsd.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Caler_赵康乐
 * @create 2020-05-02 9:05
 * @description :
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DynamicSecurityServiceConfig  {

    @Autowired
    private ResourceService resourceService;


    /***
     * 加载所有资源到DynamicSecurityService里
     * @return
     */
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<Resource> resourceList = resourceService.list();
                for (Resource resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
