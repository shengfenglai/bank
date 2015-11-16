/**
 * 
 */
package com.bank.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author laishengfeng
 * @version bank 5.0
 * @TODO hibernate读取配置文件工具类
 */
public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		try {
			Configuration cfg = new Configuration().configure();
			factory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	
	public static void closeSession(Session session) {
		if(session != null) {
			if(session.isOpen()) {
				session.close();
			}
		}
	}
}
