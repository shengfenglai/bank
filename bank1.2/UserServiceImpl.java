



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
 * @TODO UserServiceʵ����,��������ҵ���߼�
 */

public class UserServiceImpl implements UserService
{
	private static UserDaoImpl udi = new UserDaoImpl();//����һ��UserDaoImpl����
	/*�õ���д*/
	private UserServiceImpl() {}
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		synchronized(UserServiceImpl.class){ //��ס����
			return userServiceImpl;
		}
	}
	//ע��
	public String reg(String username,String password,double money) {
		String msg = "ע��ɹ���";
		try {
			udi.register(username,password,money);
		} catch (UserExitException e) {
			msg = "���û��Ѿ����ڣ�ע�᲻�ɹ���";
		}
		return msg;
	}
	//��½
	public User log(String username,String password) {
		User user = null;
		String msg = "��½�ɹ�!";
		try{
			user = udi.login(username,password);
		} catch (UserNotExitException e){
			user = new User();
			user.setUsername("�û��������ڣ�");
		} catch (PasswordErrorException e) {
			user = new User();
			user.setUsername("�û����������");
		}
		return user;
	}

	//��Ǯ
	public void saveMoney(User user,double money) {
		udi.save(user,money);
	}
	
	//ȡǮ
	public void get(User user,double money) {
		udi.getMoney(user,money);
	}
	//��ѯ���
	public void check(User user) {
		udi.checkBalance(user);
	}

	//ת��
	public String transfer(User user,String name,double money) {
		String msg = "ת�˳ɹ���";
		try {
			udi.transfer(user,name,money);
		} catch (UserNotExitException e) {
			msg = "��Ҫת���˻�������!";
		}
		return msg;
	}

}