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
 * @TODO UserDao��ʵ����
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
	 * ����û�
	 */
	public void addUser(User user) {
		sessionFactory.openSession().save(user);
	}

	/*
	 * ͨ���û��������û�������һ��User���͵Ķ���
	 */
	public User findUserByUsername(String username, String passwrod) {
		User user = null;
		String hql = "from User bu where bu.username=:username";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("username", username);
		user = (User) query.uniqueResult();
		return user;
	}

	/*
	 * ͨ��id�����û��Ľ���Ǯ
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
	 * ͨ��id�ҵ��û���
	 */
	public User findUserById(int id) {
		User user = null;
		String hql = "from User bu where bu.id=:id";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("id", id);
		user = (User) query.uniqueResult();
		return user;
	}

	/*
	 * ͨ��id�����û���ȡǮ
	 */
	public User getMoneyById(double money, int id) {
		String hql = "update User bu set bu.money=? where bu.id=?";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setParameter(0, money).setParameter(1, id);
		query.executeUpdate();
		return this.findUserById(id);
	}

	/*
	 * ͨ��id��ѯ���
	 */
	public User checkMoneyById(int id) {
		User user = null;
		String hql = "from User bu where bu.id=:id";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("id", id);
		user = (User) query.uniqueResult();
		return user;
	}

	/*
	 * ͨ���û��������û��Ľ��
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
	 * ͨ��id�����û��Ľ��
	 */
	public User transferMoney(int id, double money) {
		String hql = "update User bu set bu.money=? where bu.id=?";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setParameter(0, money).setParameter(1, id);
		query.executeUpdate();
		return this.findUserById(id);
	}

	/*
	 * ͨ���û�����user
	 */
	public User findUserByUsername(String username) {
		User user = null;
		String hql = "from User bu where bu.username=:username";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("username", username);
		user = (User) query.uniqueResult();
		return user;
	}

}
