package com.niit.mongodbquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongodbqueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbqueryApplication.class, args);
	}

	@Bean
	FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();

		filterRegistrationBean.setFilter(new com.niit.apigateway.filter.JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v2/customer/user/*");

		return filterRegistrationBean;
	}
}
