package com.xhg.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xhg.eureka.pojo.User;
import com.xhg.eureka.vo.RestResponse;

@RestController
public class helloController {

	private final Logger log = LoggerFactory.getLogger(helloController.class);
	
	@Autowired
	private Registration  registration; //服务注册
	
	@Autowired
	private DiscoveryClient client; //服务发现客户端
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		
		//ServiceInstance service = client.getInstances(registration.getServiceId());
		
		log.info("/hello, host:"+ registration.getHost()+ "" + "service_id:" + registration.getServiceId());
		
		
		return "Hello Eureka! " + name;
	}

	@RequestMapping("/get/{id}/{type}")
	public String get(@PathVariable("id") Integer id, @PathVariable("type") Integer type) {
		
		log.info("/hello, host:"+ registration.getHost()+ "" + "service_id:" + registration.getServiceId());
		
		System.out.println("id -------->:" + id);
		System.out.println("type -------->:" + type);
		
		User user = new User();
		user.setId(id);
		user.setName("哈哈哈");
		user.setAge(16);
		
		return RestResponse.success(user).toString();
	}

	
}
