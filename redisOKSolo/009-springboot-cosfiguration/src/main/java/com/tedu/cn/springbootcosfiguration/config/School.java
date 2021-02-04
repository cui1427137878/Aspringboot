package com.tedu.cn.springbootcosfiguration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * ClassName:School
 * Package:com.tedu.cn.springbootcosfiguration.config
 * Description:
 *
 * @Data:2020/11/7 11:19
 * Author:崔建新
 */
@Controller
@ConfigurationProperties(prefix = "school")
public class School {
    private String name;
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
