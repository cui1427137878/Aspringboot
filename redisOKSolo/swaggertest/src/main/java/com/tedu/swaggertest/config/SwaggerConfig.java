package com.tedu.swaggertest.config;
//http://localhost:8080/swagger-ui.html
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
//固定格式
@Configuration//配置类
@EnableSwagger2//添加到
public class SwaggerConfig {
    @Bean//将Docket添加到容器中
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("cuijianxin");
    }
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //一个Docket对应一个组名！！开发中可能要处理多个项目，所以需要组！***
                .groupName("崔建新")
                .select()

                //定义在哪个包下面扫描！！！！！
                .apis(RequestHandlerSelectors.basePackage("com.tedu.swaggertest.controller"))
                //basePackage下全扫描,none()全不扫描
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //直接这两个就可以，其他的都没什么用
                //标题！！！！
                .title("婚纱摄影后台接口管理系统")
                //描述信息！！！！
                .description("我们的小组")
                .build();
    }
}