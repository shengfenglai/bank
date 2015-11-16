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
import com.bank.exception.UserNotFoundException;
import com.bank.po.User;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @2014-9-14
 * @TODO ת��
 * @version bank 2.0
 */
public class TransferServlet extends HttpServlet {

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
		
		String username = request.getParameter("username");
		double money = Double.parseDouble(request.getParameter("money"));
		PrintWriter out = response.getWriter();
		int id = ((User)request.getSession().getAttribute("user")).getId();
		if(username != null && username!="" && request.getParameter("money") != null &&
				request.getParameter("money") != "") {
			try {
				User user = UserServiceImpl.getInstance().transfer(username, money, id);
				request.getSession().setAttribute("user", user);
			} catch (UserNotFoundException e) {
				out.print("�û���������");
			} catch(MoneyNotEnoughException e) {
				out.print("����");
			}
		} else {
			out.print("���ڿ�ѡ��޷������ύ��");
		}
		out.flush();
		out.close();
	}

}
