/**
 * 
 */
package com.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bank.dao.impl.UserDao4MySqlImpl;
import com.bank.exception.MoneyNotEnoughException;
import com.bank.exception.PasswordErrorException;
import com.bank.exception.PasswordErrorException;
import com.bank.exception.UserNotFoundException;
import com.bank.po.User;
import com.bank.service.UserService;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserServiceʵ����,�������ҵ���߼�
 * @version bank 2.0
 */
public class UserServiceImpl implements UserService {
	
	private static UserDao4MySqlImpl udi = new UserDao4MySqlImpl();//����һ��UserDaoImpl����
	/*�õ���д*/
	private UserServiceImpl() {}
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		synchronized(UserServiceImpl.class){ //��ס����
			return userServiceImpl;
		}
	}

	/*
	 *  �û�ע��
	 */
	public void register(User user) {
		udi.addUser(user);
	}

	/*  �û���½
	 */
	public User login(String username, String password) {
		User user = null;
		user = udi.findUserByUsername(username, password);
		if(user == null) {
			throw new UserNotFoundException();
		}
		
		if(!user.getPassword().equals(password)) {
			throw new PasswordErrorException();
		}
		return user;
	}

	/*  
	 * ��Ǯ
	 */
	public User saveMoney(double money, int id) {
		User user = udi.findUserById(id);
		double money1 = user.getMoney();//�õ����
		double money2 = money + money1;//�������µĽ��
		user = udi.saveMoneyById(money2, id);
		return user;
	}

	/*  
	 * ȡǮ
	 */
	public User getMoney(double money, int id) {
		User user = udi.findUserById(id);
		double money1 = user.getMoney();//�õ����
		if(money1 >= money) {
			double money2 = money1 - money; //����ȥ�µĽ��
			user = udi.getMoneyById(money2, id);
		} else {
			throw new MoneyNotEnoughException();
		}
		return user;
	}

	/*  
	 * ��ѯ���
	 */
	public User checkMoney(int id) {
		User user = null;
		user = udi.checkMoneyById(id);
		return user;
	}

	/* 
	 * ת�� 
	 */
	public User transfer(String username, double money,int id) {
		User user1 = udi.findUserById(id);//�ѵ�½��user
		User user2 = udi.findUserByUsername(username);//ת�˶���user
		if(user2 == null) {
			throw new UserNotFoundException();
		} else {
			if(user1.getMoney() >= money) {
				double myMoney = user1.getMoney() - money;
				double yourMoney = user2.getMoney() + money;
				user1 = udi.transferMoney(id, myMoney);
				user2 = udi.transferMoney(username, yourMoney);
			} else {
				throw new MoneyNotEnoughException();
			}
		}
		return user1;
	}

	/* 
	 * ��֤�û����治����
	 */
	public boolean checkUser(String username){
		User user = udi.findUserByUsername(username);
		boolean flag = true;
		if(user != null) {
			flag = true;//���û����Ѵ���
		} else {
			flag = false;
		}
		return flag ;
	}

}
