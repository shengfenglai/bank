



package com.cx.bank.model;
import com.cx.bank.model.User;
/**
 * @author laishengfeng
 * @version  bank 1.0
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