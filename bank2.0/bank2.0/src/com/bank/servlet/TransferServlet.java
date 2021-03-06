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
 * @TODO 转账
 * @version bank 2.0
 */
public class TransferServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
				out.print("用户名不存在");
			} catch(MoneyNotEnoughException e) {
				out.print("余额不足");
			}
		} else {
			out.print("存在空选项，无法进行提交！");
		}
		out.flush();
		out.close();
	}

}
