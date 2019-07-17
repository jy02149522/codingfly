package org.codingfly.common.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "codingfly",name = "swagger.title")
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${codingfly.swagger.basePackage}")
    private String basePackage;

    @Value("${codingfly.swagger.title}")
    private String title;

    @Value("${codingfly.swagger.desc}")
    private String desc;

    @Value("${codingfly.swagger.serviceUrl}")
    private String serviceUrl;



    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //包下的类，才生成接口文档
            .apis(RequestHandlerSelectors.basePackage(basePackage))
            .paths(PathSelectors.any())
            .build();
            //.securitySchemes(security());


    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(title)
            .description(desc)
            .termsOfServiceUrl(serviceUrl)
            .version("1.0.0")
            .build();
    }

//    private List<ApiKey> security() {
//        return newArrayList(
//            new ApiKey("token", "token", "header")
//        );
//    }

}