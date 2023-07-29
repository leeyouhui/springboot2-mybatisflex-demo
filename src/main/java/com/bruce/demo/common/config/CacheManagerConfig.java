package com.bruce.demo.common.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 缓存配置
 */
@Configuration
@EnableCaching
@ConditionalOnProperty(prefix = "spring.cache.caffeine", name = "spec")
public class CacheManagerConfig extends CachingConfigurerSupport {

    @Value("${spring.cache.caffeine.spec}")
    private String caffeineSpec;

    @Override
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.from(caffeineSpec));
        return cacheManager;
    }

}
