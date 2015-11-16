



package com.cx.bank.dao;
import com.cx.bank.po.User;
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO UserDao�ӿ�,�ṩ������ʵ����ʵ��
 */

public interface UserDao
{
	public void register(String username,String password,double money); //ע��
	public User login(String username,String password);     //��½
	public void save(User user,double money);//��Ǯ
	public void getMoney(User user,double money);//ȡǮ
	public void checkBalance(User user);  //��ѯ���
	public void transfer(User user,String name,double money);//ת��
	public void quit();//�˳�
}