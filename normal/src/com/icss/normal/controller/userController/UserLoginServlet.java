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

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");			
		try {
			UserService userService = new UserServiceImpl();
			User user = userService.login(name, pwd);			
			if(user!=null){
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/MainServlet").forward(request, response);
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

}
