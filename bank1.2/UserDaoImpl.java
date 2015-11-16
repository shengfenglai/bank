



package com.cx.bank.dao.impl;


import com.cx.bank.po.User;
import com.cx.bank.dao.UserDao;
import com.cx.bank.exception.UserExitException;
import com.cx.bank.exception.UserNotExitException;
import com.cx.bank.exception.PasswordErrorException;
import com.cx.bank.util.PropUtil;

import java.util.Properties;
import java.io.*;
/**
 * @author laishengfeng
 * @version bank 1.2
 * @TODO UserDaoʵ���࣬�������ݽ���
 */
public class UserDaoImpl implements UserDao
{

	/*ע���û�*/
	public void register(String username,String password,double money) {
		/*��PropUtil������������ļ�*/
		Properties prop = PropUtil.getProp(username + ".properties");
		/*������������жϣ�������û��Ѿ����ڣ�����ע�ᣬ�������*/
		if(prop == null){
			//����һ�����û���.properties���ļ�,Ȼ�������д��ȥ
			Properties props = new Properties();
			props.setProperty("username",username);
			props.setProperty("password",password);
			props.setProperty("money",money + "");
			try{
				FileOutputStream out = new FileOutputStream(".\\" + username +".properties");
				props.store(out, ".\\" + username +".properties");
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}else{
			throw new UserExitException("���û��Ѿ����ڣ�ע�᲻�ɹ���");
		}
	} 

	/*�û���½*/
	public User login(String username,String password){
		User user = null;
		/*��PropUtil������������ļ�*/
		Properties prop = PropUtil.getProp(username + ".properties");
		if(prop != null) {
			if(password.equals(prop.getProperty("password"))){
				user = new User();
				user.setUsername(prop.getProperty("username"));
				user.setPassword(prop.getProperty("password"));
				user.setMoney(Double.parseDouble(prop.getProperty("money")));
			}else {
				throw new PasswordErrorException("�û����������");
			}
		} else {
			throw new UserNotExitException("�û��������ڣ�");
		}
		return user;
	}

	/*��Ǯ*/
	public void save(User user,double money) {
		
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");
		
		//�Ѵ��ȥ��Ǯ��ԭ����Ǯ��������д��prop��ȥ
		double newMoney = Double.parseDouble(prop.getProperty("money")) + money;//�µĽ��
		user.setMoney(newMoney);//�ٰ��µ�Ǯset��user������ȥ
		prop.setProperty("money",newMoney + "");
		try{
			FileOutputStream out = new FileOutputStream(".\\" + user.getUsername() +".properties");
			prop.store(out, ".\\" + user.getUsername() +".properties");
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	/*ȡǮ*/
	public void getMoney(User user,double money) {
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");
		//��ԭ����Ǯ��ȥ����Ľ�Ȼ���ٴ浽prop��ȥ
		double newMoney = Double.parseDouble(prop.getProperty("money")) - money;
		user.setMoney(newMoney);//�ٰ��µ�Ǯset��user������ȥ
		prop.setProperty("money","" + newMoney );
		try{
			FileOutputStream out = new FileOutputStream(".\\" + user.getUsername() +".properties");
			prop.store(out, ".\\" + user.getUsername() +".properties");
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
   /*��ѯ���*/
   public void checkBalance(User user) {
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");
		double balance = Double.parseDouble(prop.getProperty("money"));
		System.out.println("�������Ϊ:" + balance);

   }

	/*ת��*/
	public void transfer(User user,String name,double money) {
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");

		//��nameΪ����properties�ļ�
		Properties prop1 = PropUtil.getProp(name + ".properties");

		if(prop1 != null) {
			double myMoney = Double.parseDouble(prop.getProperty("money"));
			double yourMoney = Double.parseDouble(prop1.getProperty("money"));
			myMoney = myMoney - money;      //�ҵ�Ǯ����money
			yourMoney = yourMoney + money;  //���Ǯ����money
			user.setMoney(myMoney);//�ٰ��µ�Ǯset��user������ȥ
			prop.setProperty("money",myMoney + "");
			prop1.setProperty("money",yourMoney + "");
			try{
				FileOutputStream out = new FileOutputStream(".\\" + user.getUsername() +".properties");
				prop.store(out, ".\\" + user.getUsername() +".properties");
				FileOutputStream out1 = new FileOutputStream(".\\" + name +".properties");
				prop1.store(out1, ".\\" + name +".properties");
			}catch(IOException e) {
				e.printStackTrace();
			}		
		}else {
			throw new  UserNotExitException("��Ҫת���˻�������!");
			//System.out.println("��Ҫת���˻�������!");
		}
	}

	/*�˳�*/
	public void quit() {
		System.exit(1);
	}
}