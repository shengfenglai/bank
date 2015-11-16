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
 * @version bank 4.0
 * @TODO ÓÃ»§µÇÂ½
 */
public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = "index";
		DynaActionForm daf = (DynaActionForm) form;
		String username = daf.getString("username");
		String password = daf.getString("password");
		User user = UserServiceImpl.getInstance().login(username, password);
		request.getSession().setAttribute("user", user);
		return mapping.findForward(path);
	}

	
}
