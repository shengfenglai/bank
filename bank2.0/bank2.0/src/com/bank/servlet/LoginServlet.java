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
 * @TODO 该servlet用来处理登陆
 * @version bank 2.0
 */
public class LoginServlet extends HttpServlet {

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
		// 接收url参数
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
				out.print("密码错误");
			} catch(UserNotFoundException e) {
				out.print("用户名不存在");
			}
		} else {
			out.println("用户名或密码不能为空");
		}
		
		out.flush();
		out.close();
			
		
	}

}
