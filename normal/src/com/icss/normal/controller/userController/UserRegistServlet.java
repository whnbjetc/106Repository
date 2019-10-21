package com.icss.normal.controller.userController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.normal.entity.User;
import com.icss.normal.service.UserService;
import com.icss.normal.service.impl.UserServiceImpl;
import com.icss.normal.util.Log;

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService userService = new UserServiceImpl();
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String uAge = request.getParameter("age");
		String uBirthday = request.getParameter("birthday");
		int age = 0;
		if(uAge!=null && !"".equals(uAge)){
			age = Integer.parseInt(uAge);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(uBirthday!=null && !"".equals(uBirthday)){
				Date birthday = sdf.parse(uBirthday);
			}
		} catch (ParseException e1) {
			Log.error(e1.getMessage());
			e1.printStackTrace();
		}
		
		User user = new User();
		user.setUaddress(address);
		user.setUname(name);
		user.setUpwd(pwd);		
		try {
			userService.regist(user);		
			request.getRequestDispatcher("/login.jsp").forward(request, response);			
		} catch (Exception e) {
			request.setAttribute("message", "Õ¯¬Á“Ï≥££¨«Î…‘∫Û‘Ÿ ‘°≠°≠");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}
