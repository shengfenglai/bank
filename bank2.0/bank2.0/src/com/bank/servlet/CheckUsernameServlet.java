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
		// 不要让浏览器开辟缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		// 程序立即过期
		response.setDateHeader("Expires", 0);
		// 不要让浏览其缓存程序
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/html");  
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		boolean flag = UserServiceImpl.getInstance().checkUser(username);
		if( flag == false) {
			out.print("可以注册");
		}else {
			out.print("用户名已存在");
		}
		
		out.flush();
		out.close();
	}

}
