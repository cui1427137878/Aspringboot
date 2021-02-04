package com.pd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication				
	
public class RunPdAPP extends WebMvcConfigurerAdapter 
implements EmbeddedServletContainerCustomizer {
	
	public static void main(String[] args) {
		SpringApplication.run(RunPdAPP.class, args);
	}
	@Override
	public void configureContentNegotiation
	(ContentNegotiationConfigurer configurer) {
		//设置可以用*.html访问json
		configurer.favorPathExtension(false);
	}
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setSessionTimeout(60*30);//单位为秒 0永不过期 		
	}
}
