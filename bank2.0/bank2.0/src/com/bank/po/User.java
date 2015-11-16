/**
 * 
 */
package com.bank.po;

/**
 * @author laishengfeng
 * @version bank 2.0
 * User实体类
 */
public class User {
	private int id;//用户id
	private String username;//用户名
	private String password;//用户密码
	private double money;//用户金额
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
