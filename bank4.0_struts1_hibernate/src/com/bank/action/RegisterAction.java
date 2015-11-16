/**
 * 
 */
package com.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;


import com.bank.po.User;
import com.bank.service.impl.UserServiceImpl;

/**
 * @author laishengfeng
 * @version bank4.0
 */
public class RegisterAction extends Action {

	/* 
	 * @TODO зЂВс
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "msg";
		DynaActionForm daf = (DynaActionForm) form;
		String username = daf.getString("username");
		String password = daf.getString("password");
		double money = (Double) daf.get("money");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		UserServiceImpl.getInstance().register(user);
		return mapping.findForward(path);
	}

}
