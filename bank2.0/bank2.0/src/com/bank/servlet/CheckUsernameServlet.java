/**
 * 
 */
package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.po.User;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @version
 * @TODO
 */
public class CheckUsernameServlet extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		boolean flag = UserServiceImpl.getInstance().checkUser(username);
		if( flag == false) {
			out.print("����ע��");
		}else {
			out.print("�û����Ѵ���");
		}
		
		out.flush();
		out.close();
	}

}
