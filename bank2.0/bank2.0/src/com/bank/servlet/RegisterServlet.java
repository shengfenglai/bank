/**
 * 
 */
package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.po.User;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO ÓÃÓÚ×¢²áµÄservlet
 * @version bank 2.0
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		double money = Double.parseDouble(request.getParameter("money"));
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		UserServiceImpl.getInstance().register(user);
		response.sendRedirect("msg.jsp");
	}


	
}
