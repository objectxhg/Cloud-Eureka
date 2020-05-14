/**
 * 
 * @date:   2020年5月14日 下午12:44:10
 */
package com.xhg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //指明这个类里面的 @Value注解进行刷新
public class HelloController {
	
	@Value("${server}")
	private String value;
	
	@RequestMapping("/hello")
	public String helloConfig() {
		
		return value;
	}
}
