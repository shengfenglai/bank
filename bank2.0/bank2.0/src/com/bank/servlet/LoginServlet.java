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

import com.bank.exception.PasswordErrorException;
import com.bank.exception.UserNotFoundException;
import com.bank.po.User;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO ��servlet���������½
 * @version bank 2.0
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
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
		// ����url����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(username != null && username !="") {
			try {
				User user = new User();
				user = UserServiceImpl.getInstance().login(username, password);
				request.getSession().setAttribute("user", user);
				//request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (PasswordErrorException e) {
				out.print("�������");
			} catch(UserNotFoundException e) {
				out.print("�û���������");
			}
		} else {
			out.println("�û��������벻��Ϊ��");
		}
		
		out.flush();
		out.close();
			
		
	}

}
