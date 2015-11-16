


package com.cx.bank.service;
import com.cx.bank.po.User;

/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO UserService接口,提供方法给实现类实现
 */
public interface UserService
{
	public String reg(String username,String password,double money);//注册
	public User log(String username,String password);//登陆
	public void saveMoney(User user,double money); //存钱
	public void get(User user,double money);//取钱
	public void check(User user);  //查询余额
	public String transfer(User user,String name,double money);//转账
}