/**
 * 
 */
package com.bank.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.stereotype.Controller;

import com.bank.po.User;
import com.bank.service.UserService;

/**
 * @author laishengfeng
 * @version bank 5.0
 * @TODO µÇÂ½
 */
@Controller("/login")
public class LoginAction extends Action {

	private UserService userService;

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = "success";
		DynaActionForm daf = (DynaActionForm) form;
		String username = daf.getString("username");
		String password = daf.getString("password");
		System.out.println("11111111");
		User user = userService.login(username, password);
		request.getSession().setAttribute("user", user);
		return mapping.findForward(path);
	}
	
	
}
