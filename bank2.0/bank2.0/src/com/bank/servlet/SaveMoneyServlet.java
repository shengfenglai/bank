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
 * @TODO ¥Ê«Æ
 * @version bank 2.0
 */
public class SaveMoneyServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double money = Double.parseDouble(request.getParameter("money"));
		//int id = Integer.parseInt(request.getParameter("id"));
		int id = ((User)request.getSession().getAttribute("user")).getId();
		User user = new User();
		user = UserServiceImpl.getInstance().saveMoney(money, id);
		request.getSession().setAttribute("user", user);
		response.sendRedirect("index.jsp");
		
	}

}
