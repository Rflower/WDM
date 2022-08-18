package com.wdm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${connect.path}")
	private String connectPath;
	@Value("${resource.path}")
	private String resourcePath;

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		
		//외부 이미지 매핑할 uri 지정
		//registry.addResourceHandler("/static/bootstrap/img/**")
		//실제 파일이 존재하는 디렉토리 지정
		//.addResourceLocations("classpath:/static/bootstrap/img/", "/static/bootstrap/img/");
		
		// addResourceHandler() : 리소스와 연결될 URL path 지정
        // 클라이언트가 파일에 접근하기 위해 요청하는 URL
        // 예: localhost:8080/imagePath/**
        // addResourceLocations() : 실세 리소스가 존재하는 외부 경로 지정
        // 경로의 마지막은 반드시 "/"로 끝나야 하고, 로컬 디스크 경로일 경우
        // 꼭 "file:///" 접두어를 붙인다.
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);

	
	}
}
