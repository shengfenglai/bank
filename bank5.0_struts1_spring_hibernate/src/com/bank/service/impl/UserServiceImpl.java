/**
 * 
 */
package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDao4MySqlImpl;
import com.bank.exception.MoneyNotEnoughException;
import com.bank.exception.PasswordErrorException;
import com.bank.exception.UserNotFoundException;
import com.bank.po.User;
import com.bank.service.UserService;
import com.bank.util.HibernateUtil;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserServiceʵ����,�������ҵ���߼�
 * @version bank 5.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private static UserDao4MySqlImpl udi = new UserDao4MySqlImpl();// ����һ��UserDaoImpl����

	private UserDao userDao;
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* �õ���д */
	private UserServiceImpl() {
	}

	private static UserServiceImpl userServiceImpl = new UserServiceImpl();

	public static UserServiceImpl getInstance() {
		synchronized (UserServiceImpl.class) { // ��ס����
			return userServiceImpl;
		}
	}

	/*
	 * �û�ע��
	 */
	public void register(User user) {
		userDao.addUser(user);
	}

	/*
	 * �û���½
	 */
	public User login(String username, String password) {
		User user = null;
		user = userDao.findUserByUsername(username, password);
		if (user == null) {
			throw new UserNotFoundException();
		}
		if (!user.getPassword().equals(password)) {
			throw new PasswordErrorException();
		}
		return user;
	}

	/*
	 * ��Ǯ
	 */
	public User saveMoney(double money, int id) {
		User user = userDao.findUserById(id);
		double money1 = user.getMoney();// �õ����
		double money2 = money + money1;// �������µĽ��
		user = userDao.saveMoneyById(money2, id);
		return user;
	}

	/*
	 * ȡǮ
	 */
	public User getMoney(double money, int id) {
		User user = userDao.findUserById(id);
		double money1 = user.getMoney();// �õ����
		if(money1 >= money) {
			double money2 = money1 - money; // ����ȥ�µĽ��
			user = userDao.getMoneyById(money2, id);
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
		user = userDao.checkMoneyById(id);
		return user;
	}

	/*
	 * ת��
	 */
	public User transfer(String username, double money, int id) {
		User user1 = userDao.findUserById(id);//�ѵ�½��user
		User user2 = userDao.findUserByUsername(username);//ת�˶���user
		if(user2 == null) {
			throw new UserNotFoundException();
		} else {
			if(user1.getMoney() >= money) {
				double myMoney = user1.getMoney() - money;
				double yourMoney = user2.getMoney() + money;
				user1 = userDao.transferMoney(id, myMoney);
				user2 = userDao.transferMoney(username, yourMoney);
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
		User user = userDao.findUserByUsername(username);
		boolean flag = true;
		if(user != null) {
			flag = true;//���û����Ѵ���
		} else {
			flag = false;
		}
		return flag ;
	}

}
