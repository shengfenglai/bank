



package com.cx.bank.service.impl;

import com.cx.bank.service.UserService;
import com.cx.bank.dao.impl.UserDaoImpl;
import com.cx.bank.po.User;
import com.cx.bank.exception.UserExitException;
import com.cx.bank.exception.UserNotExitException;
import com.cx.bank.exception.PasswordErrorException;
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO UserService实现类,处理各种业务逻辑
 */

public class UserServiceImpl implements UserService
{
	private static UserDaoImpl udi = new UserDaoImpl();//创建一个UserDaoImpl对象
	/*用单例写*/
	private UserServiceImpl() {}
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		synchronized(UserServiceImpl.class){ //锁住对象
			return userServiceImpl;
		}
	}
	//注册
	public String reg(String username,String password,double money) {
		String msg = "注册成功！";
		try {
			udi.register(username,password,money);
		} catch (UserExitException e) {
			msg = "该用户已经存在，注册不成功！";
		}
		return msg;
	}
	//登陆
	public User log(String username,String password) {
		User user = null;
		String msg = "登陆成功!";
		try{
			user = udi.login(username,password);
		} catch (UserNotExitException e){
			user = new User();
			user.setUsername("用户名不存在！");
		} catch (PasswordErrorException e) {
			user = new User();
			user.setUsername("用户名密码错误！");
		}
		return user;
	}

	//存钱
	public void saveMoney(User user,double money) {
		udi.save(user,money);
	}
	
	//取钱
	public void get(User user,double money) {
		udi.getMoney(user,money);
	}
	//查询余额
	public void check(User user) {
		udi.checkBalance(user);
	}

	//转账
	public String transfer(User user,String name,double money) {
		String msg = "转账成功！";
		try {
			udi.transfer(user,name,money);
		} catch (UserNotExitException e) {
			msg = "您要转的账户不存在!";
		}
		return msg;
	}

}