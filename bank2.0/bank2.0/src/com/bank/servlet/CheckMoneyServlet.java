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
 * @TODO ≤È—Ø”‡∂Ó
 * @version bank 2.0
 */
public class CheckMoneyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = ((User)request.getSession().getAttribute("user")).getId();
		User user = new User();
		user = UserServiceImpl.getInstance().checkMoney(id);
		request.setAttribute("user", user);
		//request.getRequestDispatcher("balance.jsp").forward(request, response);
		response.sendRedirect("balance.jsp");
	}

}
