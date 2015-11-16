/**
 * 
 */
package com.bank.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.bank.dao.UserDao;
import com.bank.po.User;
import com.bank.util.HibernateUtil;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserDao的实现类
 * @version bank 5.0
 */
@Component("userDao")
public class UserDao4MySqlImpl implements UserDao {
	private SessionFactory sessionFactory ;
	

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 添加用户
	 */
	public void addUser(User user) {
		sessionFactory.openSession().save(user);
	}

	/*
	 * 通过用户名查找用户，返回一个User类型的对象
	 */
	public User findUserByUsername(String username, String passwrod) {
		User user = null;
		String hql = "from User bu where bu.username=:username";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("username", username);
		user = (User) query.uniqueResult();
		return user;
	}

	/*
	 * 通过id更新用户的金额，存钱
	 */
	public User saveMoneyById(double money, int id) {
		String hql = "update User bu set bu.money=? where bu.id=?";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setParameter(0, money).setParameter(1, id);
		query.executeUpdate();
		//user = (User) query.uniqueResult();
		return this.findUserById(id);
	}

	/*
	 * 通过id找到用户名
	 */
	public User findUserById(int id) {
		User user = null;
		String hql = "from User bu where bu.id=:id";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("id", id);
		user = (User) query.uniqueResult();
		return user;
	}

	/*
	 * 通过id更新用户金额，取钱
	 */
	public User getMoneyById(double money, int id) {
		String hql = "update User bu set bu.money=? where bu.id=?";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setParameter(0, money).setParameter(1, id);
		query.executeUpdate();
		return this.findUserById(id);
	}

	/*
	 * 通过id查询金额
	 */
	public User checkMoneyById(int id) {
		User user = null;
		String hql = "from User bu where bu.id=:id";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("id", id);
		user = (User) query.uniqueResult();
		return user;
	}

	/*
	 * 通过用户名更新用户的金额
	 */
	public User transferMoney(String username, double money) {
		User user = null;
		String hql = "update User bu set bu.money=? where bu.username=?";
		Query query = sessionFactory.openSession().createQuery(hql)
				.setParameter(0, money).setParameter(1, username);
		query.executeUpdate();
		return this.findUserByUsername(username);
	}

	/*
	 * 通过id更新用户的金额
	 */
	public User transferMoney(int id, double money) {
		String hql = "update User bu set bu.money=? where bu.id=?";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setParameter(0, money).setParameter(1, id);
		query.executeUpdate();
		return this.findUserById(id);
	}

	/*
	 * 通过用户名找user
	 */
	public User findUserByUsername(String username) {
		User user = null;
		String hql = "from User bu where bu.username=:username";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("username", username);
		user = (User) query.uniqueResult();
		return user;
	}

}
