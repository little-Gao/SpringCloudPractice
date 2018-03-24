package com.gzk.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter extends ZuulFilter{

	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String token = request.getParameter("token");
		if(token == null || "".equals(token)){
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}

	public boolean shouldFilter() {
		return true;
	}
	
	/**
	 * 该过滤器位于第几个，指定过滤器的执行顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 * filterOrder：过滤的顺序
	 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
