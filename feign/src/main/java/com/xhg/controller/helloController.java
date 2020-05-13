/**
 * 
 * @date:   2020年5月11日 下午11:12:38
 */
package com.xhg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xhg.feign.HelloFeign;

/**
 *
 * @date:  2020年5月11日 下午11:12:38 
 * @author Administrator
 * @Description:TODO(描述这个类的作用)
 */

@RestController
public class helloController {
	
	@Autowired
	private HelloFeign helloFeign;
	
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod = "fallbackHello")
	public String helloConsumer(@PathVariable("name") String name) {
		
		return helloFeign.hello(name);
	}
	
	/**
	 * 断路器方法 返回值必须和方法一致 参数也一致
	 * 当发生异常时，直接返回默认值，称为：Hystrix 降级
	 * 会有一个bug 断路器启动后，第一次访问就到断路器，不正常。第一次进入断路器不算数
	 */
	public String fallbackHello(String name) {
		return "服务器正忙";   
	}
	
	@RequestMapping("/get/{id}/{type}")
	public String get(@PathVariable("id") Integer id, @PathVariable("type") Integer type) {
		
		return helloFeign.get(id, type);
	}
}
