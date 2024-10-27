//package com.caijiale.paipai.commons.config.swagger;
//
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//@EnableKnife4j
//public class SwaggerConfig {
//
//    @Bean(value = "userApi")
//    public Docket groupRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(groupApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo groupApiInfo() {
//        return new ApiInfoBuilder()
//                .title("通用模块")
//                .description("通用模块接口文档说明")
//                .termsOfServiceUrl("http://www.group.com/")
//                .contact("group@qq.com")
//                .version("1.0")
//                .build();
//    }
//
//
//}