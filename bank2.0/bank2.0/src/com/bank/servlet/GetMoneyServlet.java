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

import com.bank.exception.MoneyNotEnoughException;
import com.bank.po.User;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO ȡǮ��servlet
 * @version bank 2.0
 */
public class GetMoneyServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��Ҫ����������ٻ���
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		// ������������
		response.setDateHeader("Expires", 0);
		// ��Ҫ������仺�����
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		double money = Double.parseDouble(request.getParameter("money"));
		// System.out.println(money);
		// int id = Integer.parseInt(request.getParameter("id"));
		int id = ((User) request.getSession().getAttribute("user")).getId();
		PrintWriter out = response.getWriter();
		User user = new User();
		try {
			user = UserServiceImpl.getInstance().getMoney(money, id);
			request.getSession().setAttribute("user", user);
			// response.sendRedirect("index.jsp");
			// response.setHeader("refresh", "2,URL=index.jsp");
		} catch (MoneyNotEnoughException e) {
			out.print("����");
		}
		out.flush();
		out.close();
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

}
