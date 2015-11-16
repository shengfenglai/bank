/**
 * 
 */
package com.bank.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bank.dao.UserDao;
import com.bank.po.User;
import com.bank.util.HibernateUtil;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserDao的实现类
 * @version bank 4.0
 */
public class UserDao4MySqlImpl implements UserDao {

	/*
	 * 添加用户
	 */
	public void addUser(User user) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/*
	 * 通过用户名查找用户，返回一个User类型的对象
	 */
	public User findUserByUsername(String username, String passwrod) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			List list = session
					.createQuery("from User bu where bu.username=:username")
					.setParameter("username", username).list();
			user = (User) list.get(0);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}

	/*
	 * 通过id更新用户的金额
	 */
	public User saveMoneyById(double money, int id) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			user = (User) session.load(User.class, id);
			user.setMoney(money);
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

		return user;
	}

	/*
	 * 通过id找到用户名
	 */
	public User findUserById(int id) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			user = (User) session.load(User.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}

	/*
	 * 通过id更新用户金额
	 */
	public User getMoneyById(double money, int id) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			user = (User) session.load(User.class, id);
			user.setMoney(money);
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return this.findUserById(id);
	}

	/*
	 * 通过id查询金额
	 */
	public User checkMoneyById(int id) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			user = (User) session.load(User.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}

	/*
	 * 通过用户名更新用户的金额
	 */
	public User transferMoney(String username, double money) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			List list = session
					.createQuery("from User bu where bu.username=:username")
					.setParameter("username", username).list();
			user = (User) list.get(0);
			user.setMoney(money);
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}

	/*
	 * 通过id更新用户的金额
	 */
	public User transferMoney(int id, double money) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			user = (User) session.load(User.class, id);
			user.setMoney(money);
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return this.findUserById(id);
	}

	/*
	 * 通过用户名找user
	 */
	public User findUserByUsername(String username) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			List list = session.createQuery("from User bu where bu.username=:username")
					.setParameter("username", username).list();
			user = (User) list.get(0);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}

}
