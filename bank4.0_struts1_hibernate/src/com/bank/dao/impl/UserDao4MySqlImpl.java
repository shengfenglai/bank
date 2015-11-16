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
 * @TODO UserDao��ʵ����
 * @version bank 4.0
 */
public class UserDao4MySqlImpl implements UserDao {

	/*
	 * ����û�
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
	 * ͨ���û��������û�������һ��User���͵Ķ���
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
	 * ͨ��id�����û��Ľ��
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
	 * ͨ��id�ҵ��û���
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
	 * ͨ��id�����û����
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
	 * ͨ��id��ѯ���
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
	 * ͨ���û��������û��Ľ��
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
	 * ͨ��id�����û��Ľ��
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
	 * ͨ���û�����user
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
