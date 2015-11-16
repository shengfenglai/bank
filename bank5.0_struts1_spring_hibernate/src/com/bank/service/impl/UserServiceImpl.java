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
 * @TODO UserService实现类,处理各种业务逻辑
 * @version bank 5.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private static UserDao4MySqlImpl udi = new UserDao4MySqlImpl();// 创建一个UserDaoImpl对象

	private UserDao userDao;
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* 用单例写 */
	private UserServiceImpl() {
	}

	private static UserServiceImpl userServiceImpl = new UserServiceImpl();

	public static UserServiceImpl getInstance() {
		synchronized (UserServiceImpl.class) { // 锁住对象
			return userServiceImpl;
		}
	}

	/*
	 * 用户注册
	 */
	public void register(User user) {
		userDao.addUser(user);
	}

	/*
	 * 用户登陆
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
	 * 存钱
	 */
	public User saveMoney(double money, int id) {
		User user = userDao.findUserById(id);
		double money1 = user.getMoney();// 拿到余额
		double money2 = money + money1;// 余额加上新的金额
		user = userDao.saveMoneyById(money2, id);
		return user;
	}

	/*
	 * 取钱
	 */
	public User getMoney(double money, int id) {
		User user = userDao.findUserById(id);
		double money1 = user.getMoney();// 拿到余额
		if(money1 >= money) {
			double money2 = money1 - money; // 余额减去新的金额
			user = userDao.getMoneyById(money2, id);
		} else {
			throw new MoneyNotEnoughException();
		}
		return user;
	}

	/*
	 * 查询余额
	 */
	public User checkMoney(int id) {
		User user = null;
		user = userDao.checkMoneyById(id);
		return user;
	}

	/*
	 * 转账
	 */
	public User transfer(String username, double money, int id) {
		User user1 = userDao.findUserById(id);//已登陆的user
		User user2 = userDao.findUserByUsername(username);//转账对象user
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
	 * 验证用户名存不存在
	 */
	public boolean checkUser(String username){
		User user = userDao.findUserByUsername(username);
		boolean flag = true;
		if(user != null) {
			flag = true;//该用户名已存在
		} else {
			flag = false;
		}
		return flag ;
	}

}
