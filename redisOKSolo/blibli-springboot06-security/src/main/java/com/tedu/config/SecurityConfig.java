package com.tedu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则，规定需要哪些权限才有权访问
        http.authorizeRequests().antMatchers("/").permitAll()//首页所有人都可以访问
                .antMatchers("/level1/**").hasRole("vip1")//设置vip不同等级的访问权限
                //这些就代表用户必须拥有vip1的权限，才能够访问资源level1目录下的内容，否则无法访问
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
            http.formLogin().loginPage("/Tologin").permitAll();
    }


   /* protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("cuijianxin").password("123").roles("vip3");
    }*/
}
