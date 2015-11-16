/**
 * 
 */
package com.bank.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.bank.exception.MoneyNotEnoughException;
import com.bank.po.User;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @version bank 5.0
 */
@Controller("/user")
public class UserAction extends DispatchAction {

	private UserService userService;

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/*
	 * ע��
	 */
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = "msg";
		DynaActionForm daf = (DynaActionForm) form;
		String username = daf.getString("username");
		String password = daf.getString("password");
		double money = (Double) daf.get("money");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		userService.register(user);
		return mapping.findForward(path);
	}

	/*
	 * ��ѯ���
	 */
	public ActionForward balance(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = ((User) request.getSession().getAttribute("user")).getId();
		User user = new User();
		user = userService.checkMoney(id);
		return mapping.findForward("balance");
	}

	/*
	 * ȡ��
	 */
	public ActionForward getMoney(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = "getMoney";
		DynaActionForm daf = (DynaActionForm) form;
		int id = ((User) request.getSession().getAttribute("user")).getId();
		double money = (Double) daf.get("money");
		PrintWriter out = response.getWriter();
		User user = new User();
		try {
			user = userService.getMoney(money, id);
			request.getSession().setAttribute("user", user);
		} catch (MoneyNotEnoughException e) {
			out.print("����");
		}
		out.flush();
		out.close();

		return mapping.findForward(path);
	}

	/*
	 * ���
	 */
	public ActionForward saveMoney(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = "saveMoney";
		DynaActionForm daf = (DynaActionForm) form;
		int id = ((User) request.getSession().getAttribute("user")).getId();
		double money = (Double) daf.get("money");
		User user = new User();
		user = userService.saveMoney(money, id);
		request.getSession().setAttribute("user", user);
		return mapping.findForward(path);
	}

	/*
	 * ת��
	 */
	public ActionForward transferMoney(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = "transferMoney";
		DynaActionForm daf = (DynaActionForm) form;
		int id = ((User) request.getSession().getAttribute("user")).getId();
		double money = (Double) daf.get("money");
		String username = daf.getString("username");
		User user = new User();
		user = userService.transfer(username, money, id);
		request.getSession().setAttribute("user", user);
		return mapping.findForward(path);
	}

	/*
	 * ע��
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		return mapping.findForward("logout");
	}

	/*
	 * ����û����Ƿ����
	 */
	public ActionForward checkUsername(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		boolean flag = userService.checkUser(username);
		if (flag == false) {
			out.print("����ע��");
		} else {
			out.print("�û����Ѵ���");
		}
		out.flush();
		out.close();
		return null;
	}

}
