package com.caler.zkl.openpsd.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-10 20:02
 * @description :
 */
@Data
@ConfigurationProperties(value = "system.ctrl")
@Configuration
public class SystemCtlConfig {
   private List<String>  urls = new ArrayList<>();
}
