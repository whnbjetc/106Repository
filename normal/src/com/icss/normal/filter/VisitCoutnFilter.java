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
			response.getWriter().print("ϵͳ��æ�����Ժ����ԡ���");
		}
	}
	
	public boolean visitCount(String ip) {  
		Jedis jedis = new Jedis("127.0.0.1", 6379); 
		String value = jedis.get(ip);  
		if (value == null) {  
			//��ʼ��ʱ����IP���ʴ���Ϊ1  
			jedis.set(ip, "1");  
			//����IP������ʱ��Ϊ60�룬60����IP�ķ��ʴ����ɳ������  
			jedis.expire(ip, 60);  
		} else {  
			int parseInt = Integer.parseInt(value);  
			//���60����IP�ķ��ʴ�������10������false
			if (parseInt > 10) {  
				return false;  
			} else {
				//���û��10�Σ���������  
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
