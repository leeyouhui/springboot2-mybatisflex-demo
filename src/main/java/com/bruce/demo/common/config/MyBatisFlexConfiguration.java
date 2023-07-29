package com.bruce.demo.common.config;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import com.mybatisflex.core.audit.AuditManager;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc mybaitis-flex配置
 */
@Configuration
@Slf4j
public class MyBatisFlexConfiguration implements MyBatisFlexCustomizer {

    public MyBatisFlexConfiguration() {
        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置 SQL 审计收集器
        AuditManager.setMessageCollector(auditMessage ->
                log.info("sql={}, cost={}ms", auditMessage.getFullSql(), auditMessage.getElapsedTime())
        );
    }

    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
        //我们可以在这里进行一些列的初始化配置
    }
}