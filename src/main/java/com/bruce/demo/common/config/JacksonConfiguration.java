package com.bruce.demo.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc jackson配置
 */
@Configuration(proxyBeanMethods = false)
//@ConditionalOnClass(Jackson2ObjectMapperBuilder.class)
public class JacksonConfiguration {
    /**
     * sf-boot覆盖了spring boot的配置
     * sf-boot 所有null值序列化json时写入空字符串，容易造成调用者序列化异常
     * 此处覆盖sf-boot的配置，取消这个特性
     *
     * @param builder spring boot创建的builder
     * @return ObjectMapper实例
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean
    ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        return builder.createXmlMapper(false).build();
    }
}
