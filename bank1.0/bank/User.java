



package com.cx.bank.model;
/**
 * @author laishengfeng
 * @version bank 1.0
 * @TODO Userʵ����
 */
public class User
{
	private String username; //�û���
	private String password; //����
	private double money;    //�ҵĽ��
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

	public double getMoney(){
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}