package com.bruce.demo.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 系统配置类
 */
@Component
@ConfigurationProperties(prefix = "system-config.db")
@Data
public class DbProperties {
    private Long maxQueueSize;
    private Long maxInsertSize;
    private Long maxUpdateSize;

}
