package com.bruce.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc swagger配置类
 */
@ConditionalOnProperty(prefix = "swagger", name = "enable", havingValue = "true")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.basePackage:com.bruce}")
    private String basePackage;
    @Value("${swagger.title:api文档}")
    private String title;
    @Value("${swagger.description:swagger接口文档}")
    private String description;
    @Value("${swagger.termsOfServiceUrl:http://localhost}")
    private String termsOfServiceUrl;
    @Value("${swagger.version:V1.0}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 多个包使用 ";" 分隔
                //.apis(FwRequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .version(version)
                .build();
    }
}
