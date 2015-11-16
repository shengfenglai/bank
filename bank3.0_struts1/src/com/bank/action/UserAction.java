/**
 * 
 */
package com.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.bank.po.User;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @version bank 3.0
 */
public class UserAction extends DispatchAction {


	/* 
	 * ��ѯ���
	 */
	public ActionForward balance(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = ((User)request.getSession().getAttribute("user")).getId();
		User user  = new User();
		user = UserServiceImpl.getInstance().checkMoney(id);
		return mapping.findForward("balance");
	}
	
	/* 
	 * ȡ��
	 */
	public ActionForward getMoney(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index";
		DynaActionForm daf = (DynaActionForm) form;
		int id = ((User) request.getSession().getAttribute("user")).getId();
		double money = (Double) daf.get("money");
		User user = new User();
		user = UserServiceImpl.getInstance().getMoney(money, id);
		request.getSession().setAttribute("user", user);
		return mapping.findForward(path);
	}

	/* 
	 * ���
	 */
	public ActionForward saveMoney(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index";
		DynaActionForm daf = (DynaActionForm) form;
		int id = ((User) request.getSession().getAttribute("user")).getId();
		double money = (Double) daf.get("money");
		User user = new User();
		user = UserServiceImpl.getInstance().saveMoney(money, id);
		request.getSession().setAttribute("user", user);
		return mapping.findForward(path);
	}
	
	
	/* 
	 * ת��
	 */
	public ActionForward transferMoney(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index";
		DynaActionForm daf = (DynaActionForm) form;
		int id = ((User) request.getSession().getAttribute("user")).getId();
		double money = (Double) daf.get("money");
		String username = daf.getString("username");
		User user = new User();
		user = UserServiceImpl.getInstance().transfer(username, money, id);
		request.getSession().setAttribute("user", user);
		return mapping.findForward(path);
	}
	
	
	/* 
	 * ע��
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return mapping.findForward("index");
	}
	
	
}
