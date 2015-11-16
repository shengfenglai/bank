



package com.cx.bank.dao;
import com.cx.bank.po.User;
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO UserDao接口,提供方法给实现类实现
 */

public interface UserDao
{
	public void register(String username,String password,double money); //注册
	public User login(String username,String password);     //登陆
	public void save(User user,double money);//存钱
	public void getMoney(User user,double money);//取钱
	public void checkBalance(User user);  //查询余额
	public void transfer(User user,String name,double money);//转账
	public void quit();//退出
}