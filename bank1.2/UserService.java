


package com.cx.bank.service;
import com.cx.bank.po.User;

/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO UserService�ӿ�,�ṩ������ʵ����ʵ��
 */
public interface UserService
{
	public String reg(String username,String password,double money);//ע��
	public User log(String username,String password);//��½
	public void saveMoney(User user,double money); //��Ǯ
	public void get(User user,double money);//ȡǮ
	public void check(User user);  //��ѯ���
	public String transfer(User user,String name,double money);//ת��
}