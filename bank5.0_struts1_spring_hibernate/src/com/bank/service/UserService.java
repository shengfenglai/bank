/**
 * 
 */
package com.bank.service;

import java.util.List;

import com.bank.po.User;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserService接口
 * @version bank 5.0
 */
public interface UserService {
	public void register(User user); //注册用户
	public User login(String username,String password);//用户登陆
	public User saveMoney(double money,int id);//存钱
	public User getMoney(double money,int id);//取钱
	public User checkMoney(int id);//查询余额
	public User transfer(String username,double money,int id);//转账
	public boolean checkUser(String username);//检查用户名是否存在
}
