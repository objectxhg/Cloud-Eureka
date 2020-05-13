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
	public String helloConsumer(@PathVariable("name") String name) {
		
		return helloFeign.hello(name);
	}
	
	@RequestMapping("/get/{id}/{type}")
	public String get(@PathVariable("id") Integer id, @PathVariable("type") Integer type) {
		
		return helloFeign.get(id, type);
	}
}
