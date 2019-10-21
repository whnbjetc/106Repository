package com.icss.normal.controller.userController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.normal.entity.User;
import com.icss.normal.exception.NullException;
import com.icss.normal.service.UserService;
import com.icss.normal.service.impl.UserServiceImpl;
import com.icss.normal.util.Log;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mark = request.getParameter("mark");
		
		try {
			if("login".equals(mark)){
				login(request,response);
			}else if("reg".equals(mark)){
				reg(request,response);
			}else{
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
	
	

	/**
	 * 用户登录
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");			
		try {
			UserService userService = new UserServiceImpl();
			User user = userService.login(name, pwd);			
			if(user!=null){
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "用户名或者密码输入有误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (NullException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "网络异常，请稍后再试……");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * 用户注册
	 */
	private void reg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		UserService userService = new UserServiceImpl();
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		
		User user = new User();
		user.setUaddress(address);
		user.setUname(name);
		user.setUpwd(pwd);		
		try {
			userService.regist(user);		
			request.getRequestDispatcher("/login.jsp").forward(request, response);			
		} catch (Exception e) {
			request.setAttribute("errorMsg", "网络异常，请稍后再试……");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}
