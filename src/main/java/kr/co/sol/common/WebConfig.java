package kr.co.sol.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Value("${resources.location}")
    private String resourcesLocation;
    @Value("${resources.uri_path}")
    private String resourcesUriPath;
    
	/*
    	addResourceHandlers :
    		'리소스 등록' 및 '핸들러를 관리'하는 객체인
    		ResourceHandlerRegistry 를 통해 
    		리소스 위치와 이 리소스와 매칭될 url 등록 
    */
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//외부 경로는 서버가 아닌 경로(shop) 일때는 file:///이 필요
    	registry.addResourceHandler(resourcesUriPath + "/**")  //   /upload/**
    	.addResourceLocations("file:///" + resourcesLocation); //   file:///C:/study/upload

    }

}