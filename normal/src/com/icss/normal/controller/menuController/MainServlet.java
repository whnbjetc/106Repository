package com.icss.normal.controller.menuController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.normal.entity.Menu;
import com.icss.normal.service.MenuService;
import com.icss.normal.service.impl.MenuServiceImpl;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			MenuService menuService = new MenuServiceImpl();
			List<Menu> list = menuService.findAllMenuRedis();	
			request.setAttribute("menuList", list);			
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "查询所有菜品信息失败");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}
