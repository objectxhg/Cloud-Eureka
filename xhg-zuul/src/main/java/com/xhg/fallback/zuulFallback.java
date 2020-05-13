/**
 * 
 * @date:   2020年5月13日 下午6:12:28
 */
package com.xhg.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.client.http.HttpResponse;

/**
 *
 * @date:  2020年5月13日 下午6:12:28 
 * @author Administrator
 * @Description:TODO(描述这个类的作用)
 */
@Component
public class zuulFallback implements FallbackProvider{

	@Override
	public String getRoute() {
		return "*";	//路由 * 通用
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		
		return new ClientHttpResponse() {
			
			@Override //消息头
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
			
			@Override //返回内容信息
			public InputStream getBody() throws IOException {
				String msg = "服务器正忙！zuul"; //可构造json串
				return new ByteArrayInputStream(msg.getBytes());
			}
			
			@Override //状态文字描述
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
			@Override //状态码
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override //状态码的值
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}
			
			@Override
			public void close() {
				
			}
		};
	}
	
}
