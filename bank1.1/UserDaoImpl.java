



package com.cx.bank.model;

import java.util.Properties;
import java.io.*;
import com.cx.bank.model.UserDao;
import com.cx.bank.util.PropUtil;
import com.cx.bank.model.User;
/**
 * @author laishengfeng
 * @version bank 1.1
 * @TODO UserDao实现类，用来数据交互
 */
public class UserDaoImpl implements UserDao
{

	/*注册用户*/
	public void register(String username,String password,double money) {
		/*用PropUtil工具类读配置文件*/
		Properties prop = PropUtil.getProp(username + ".properties");

		/*这里进行条件判断，如果该用户已经存在，则不能注册，否则可以*/
		if(prop == null){
			//生成一个以用户名.properties的文件,然后把内容写进去
			Properties props = new Properties();
			props.setProperty("username",username);
			props.setProperty("password",password);
			props.setProperty("money",money + "");
			try{
				FileOutputStream out = new FileOutputStream(".\\" + username +".properties");
				props.store(out, ".\\" + username +".properties");
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}else{
			System.out.println("该用户已经存在，注册不成功！");
		}
	} 

	/*用户登陆*/
	public User login(String username,String password){
		User user = null;
		/*用PropUtil工具类读配置文件*/
		Properties prop = PropUtil.getProp(username + ".properties");
		if(prop != null) {
			if(password.equals(prop.getProperty("password"))){
				user = new User();
				user.setUsername(prop.getProperty("username"));
				user.setPassword(prop.getProperty("password"));
				user.setMoney(Double.parseDouble(prop.getProperty("money")));
				System.out.println("登陆成功！");
				return user;

			}else {
				System.out.println("输入的密码不对！");
			}
		} else {
			System.out.println("用户名不存在！");
		}
		return user;
	}

	/*存钱*/
	public void save(User user,double money) {
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");
		//把存进去的钱和原来的钱加起来再写到prop中去
		double newMoney = Double.parseDouble(prop.getProperty("money")) + money;//新的金额
		user.setMoney(newMoney);//再把新的钱set到user对象中去
		prop.setProperty("money",newMoney + "");
		try{
			FileOutputStream out = new FileOutputStream(".\\" + user.getUsername() +".properties");
			prop.store(out, ".\\" + user.getUsername() +".properties");
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	/*取钱*/
	public void getMoney(User user,double money) {
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");
		//把原来的钱减去输入的金额，然后再存到prop中去
		double newMoney = Double.parseDouble(prop.getProperty("money")) - money;
		user.setMoney(newMoney);//再把新的钱set到user对象中去
		prop.setProperty("money","" + newMoney );
		try{
			FileOutputStream out = new FileOutputStream(".\\" + user.getUsername() +".properties");
			prop.store(out, ".\\" + user.getUsername() +".properties");
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
   /*查询余额*/
   public void checkBalance(User user) {
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");
		double balance = Double.parseDouble(prop.getProperty("money"));
		System.out.println("您的余额为:" + balance);

   }

	/*转账*/
	public void transfer(User user,String name,double money) {
		Properties prop = PropUtil.getProp(user.getUsername() + ".properties");

		//以name为名的properties文件
		Properties prop1 = PropUtil.getProp(name + ".properties");

		if(prop1 != null) {
			double myMoney = Double.parseDouble(prop.getProperty("money"));
			double yourMoney = Double.parseDouble(prop1.getProperty("money"));
			myMoney = myMoney - money;      //我的钱减少money
			yourMoney = yourMoney + money;  //你的钱增加money
			user.setMoney(myMoney);//再把新的钱set到user对象中去
			prop.setProperty("money",myMoney + "");
			prop1.setProperty("money",yourMoney + "");
			try{
				FileOutputStream out = new FileOutputStream(".\\" + user.getUsername() +".properties");
				prop.store(out, ".\\" + user.getUsername() +".properties");
				FileOutputStream out1 = new FileOutputStream(".\\" + name +".properties");
				prop1.store(out1, ".\\" + name +".properties");
			}catch(IOException e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("您要转的账户不存在!");
		}
	}

	/*退出*/
	public void quit() {
		System.exit(1);
	}
}