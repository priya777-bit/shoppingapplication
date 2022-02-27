package com.niit.mongodbquery;

import com.niit.mongodbquery.filter.JwtFilter;
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

		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/user/*");

		return filterRegistrationBean;
	}

}
