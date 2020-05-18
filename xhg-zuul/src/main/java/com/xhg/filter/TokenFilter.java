/**
 * @author Administrator
 * @date:   2020年5月18日 下午3:31:40
 * @Description:TODO(描述这个类的作用)
 * 
 */
package com.xhg.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 */

public class TokenFilter extends ZuulFilter {

	@Override
	public String filterType() {
		// 在路由之前进行过滤
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// 自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		// 获取请求上下文
		RequestContext context = RequestContext.getCurrentContext();
		// 获取到request
		HttpServletRequest request = context.getRequest();
		String token = request.getParameter("token");

		if (token == null) {
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			context.setResponseBody("unAuthrized");
			return false;
		} else {
			System.out.println("过滤器：shouldFilter");
			return true;
		}
		/**
		 * 是否执行该过滤器，此处为true，说明需要过滤 去执行下面的run方法 或者说是执行过滤器所需的条件 条件符合去执行下面的run方法
		 */

	}

	@Override
	public Object run() throws ZuulException {
		// 过滤的逻辑
		System.out.println("zuul:过滤器 run");
		
		
		return null;
	}

}
