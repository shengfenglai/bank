/**
 * 
 */
package com.bank.service;

import java.util.List;

import com.bank.po.User;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserService�ӿ�
 * @version bank 3.0
 */
public interface UserService {
	public void register(User user); //ע���û�
	public User login(String username,String password);//�û���½
	public User saveMoney(double money,int id);//��Ǯ
	public User getMoney(double money,int id);//ȡǮ
	public User checkMoney(int id);//��ѯ���
	public User transfer(String username,double money,int id);//ת��
	public boolean checkUser(String username);
}
