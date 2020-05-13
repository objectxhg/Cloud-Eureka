/**
 * 
 * @date:   2020年5月11日 下午11:04:31
 */
package com.xhg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 调用服务提供者
 */
@FeignClient("hello-service")
public interface HelloFeign {
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name);
	
	@RequestMapping("/get/{id}/{type}")
	public String get(@PathVariable("id") Integer id, @PathVariable("type") Integer type);
}
