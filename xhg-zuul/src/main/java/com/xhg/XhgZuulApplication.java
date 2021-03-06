package com.xhg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.xhg.filter.TokenFilter;

@SpringBootApplication
@EnableZuulProxy //开启网关代理
public class XhgZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(XhgZuulApplication.class, args);
	}
	
	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}
}
