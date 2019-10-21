package com.icss.normal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import redis.clients.jedis.Jedis;

public class VisitCoutnFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		String ip = request.getRemoteHost();
		if(visitCount(ip)){
			chain.doFilter(request, response);
		}else{
			response.getWriter().print("系统繁忙，请稍后再试……");
		}
	}
	
	public boolean visitCount(String ip) {  
		Jedis jedis = new Jedis("127.0.0.1", 6379); 
		String value = jedis.get(ip);  
		if (value == null) {  
			//初始化时设置IP访问次数为1  
			jedis.set(ip, "1");  
			//设置IP的生存时间为60秒，60秒内IP的访问次数由程序控制  
			jedis.expire(ip, 60);  
		} else {  
			int parseInt = Integer.parseInt(value);  
			//如果60秒内IP的访问次数超过10，返回false
			if (parseInt > 10) {  
				return false;  
			} else {
				//如果没有10次，可以自增  
				jedis.incr(ip);  
			}  
		}  
		return true;  
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
