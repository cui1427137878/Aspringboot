package com.tedu.springbootmybatis0821;

import org.springframework.boot.context.properties.ConfigurationProperties;

//没在MybatisAutoConfiguration引用之前会报错。
@ConfigurationProperties(prefix = "com.tedu.mybatis")
public class MybatisProperties {
    String url="localhost";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
