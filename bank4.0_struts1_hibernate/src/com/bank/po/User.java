/**
 * 
 */
package com.bank.po;

/**
 * @author laishengfeng
 * @version bank 4.0
 * Userʵ����
 */
public class User {
	private int id;//�û�id
	private String username;//�û���
	private String password;//�û�����
	private double money;//�û����
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
