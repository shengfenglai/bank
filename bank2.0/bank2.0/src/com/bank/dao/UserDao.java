/**
 * 
 */
package com.bank.dao;

import java.util.List;

import com.bank.po.User;

/**
 * @author laishengfeng
 * @2014-9-13
 * @TODO UserDao接口
 * @version bank 2.0
 */
public interface UserDao extends BaseDao {
	public void addUser(User user);//添加User
	public User findUserByUsername(String username,String passwrod);//通过用户名查找用户，返回一个User类型的对象
	public User saveMoneyById(double money,int id);//通过id更新用户的金额
	public User findUserById(int id);//通过id找到用户
	public User getMoneyById(double money,int id);//通过id更新用户金额
	public User checkMoneyById(int id);//通过id查询
	public User transferMoney(String username,double money);//通过用户名更新用户的金额
	public User transferMoney(int id,double money);//通过id更新用户的金额
	public User findUserByUsername(String username);//通过用户名来找到用户
	
}
