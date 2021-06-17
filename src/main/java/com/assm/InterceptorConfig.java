package com.assm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.assm.interceptor.AdminInterceptor;
import com.assm.interceptor.AuthenticateInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	AuthenticateInterceptor authInterceptor;
	
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
			.addPathPatterns("/home/giohang/**", "/admin/**")
			.excludePathPatterns("/login");

		registry.addInterceptor(adminInterceptor)
			.addPathPatterns("/admin/**")
			.excludePathPatterns("/login", "/admin/order/create");
	}
}
