/**
 * 
 */
package com.bank.dao;

import java.util.List;

import com.bank.po.User;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserDao�ӿ�
 * @version bank 5.0
 */
public interface UserDao extends BaseDao {
	public void addUser(User user);//���User
	public User findUserByUsername(String username,String passwrod);//ͨ���û��������û�������һ��User���͵Ķ���
	public User saveMoneyById(double money,int id);//ͨ��id�����û��Ľ��
	public User findUserById(int id);//ͨ��id�ҵ��û�
	public User getMoneyById(double money,int id);//ͨ��id�����û����
	public User checkMoneyById(int id);//ͨ��id��ѯ
	public User transferMoney(String username,double money);//ͨ���û��������û��Ľ��
	public User transferMoney(int id,double money);//ͨ��id�����û��Ľ��
	public User findUserByUsername(String username);//ͨ���û������ҵ��û�
	
}
