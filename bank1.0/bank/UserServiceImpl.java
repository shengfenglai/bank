



package com.cx.bank.message;
import java.util.*;
import com.cx.bank.message.UserService;
import com.cx.bank.model.UserDaoImpl;

import com.cx.bank.model.User;

/**
 * @author laishengfeng
 * @version  bank 1.0
 * @TODO 此类用来处理业务逻辑以及一些类的封装
 */
public class UserServiceImpl implements UserService
{
	private static UserDaoImpl udi = new UserDaoImpl();//创建一个UserDaoImpl对象
	/*用单例写，后面让main方法直接访问*/
	private UserServiceImpl() {}
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		return userServiceImpl;
	}
	
	Scanner input = new Scanner(System.in);

	/*程序的入口方法*/
	public void entry() {
		UserDaoImpl udi = new UserDaoImpl();//创建一个UserDaoImpl对象
		System.out.println("---欢迎来到XXX银行,您的满意是我们的追求！---");
		System.out.println("1、注册");
		System.out.println("2、登陆");
		System.out.println("3、退出");
		User user = null;
		int flag = input.nextInt(); //flag用来判断用户选择需要服务的类型
		while (flag != 1 && flag != 2 && flag != 3)
		{
			System.out.println("请输入上述已有的序号:");
			flag = input.nextInt();
		}
		switch(flag) {
		case 1:
			/*把输入的内容赋给name*/
			System.out.println("请输入您要注册的用户名:");
			String username = input.next();
		
			/*把输入的内容赋给password*/
			System.out.println("请输入您注册用户的密码:");
			String password = input.next();
		
			/*把输入的内容赋给money*/
			System.out.println("请输入您的存款金额:");
			double money = input.nextDouble();
			/*对输入的金额进行判断*/
			while(money < 10) {
				System.out.println("输入的金额不规范！！");
				System.out.println("请重新输入您的存款金额:");
				money = input.nextDouble();
			}
			/*对注册的密码进行控制，控制为六位数字*/
			if(isNum(password) && (password.length() == 6)) {
				udi.register(username,password,money);//调用方法完成注册
				System.out.println("注册成功！");
				entry();
			}else {
				System.out.println("请输入六位数字作为密码！");
			}
			
			break;

		case 2:
			System.out.println("请输入登陆名:");
			username = input.next();
			System.out.println("请输入密码:");
			password = input.next();
			user = udi.login(username,password);
			//如果登陆成功则跳到操作的界面，否则还是在入口界面
			if(user == null){
				entry();
			} else{
				control(user);
			}
			break;
		case 3:
			System.exit(1);
			break;
		}
	}
	
	/*登陆成功之后进行存，取，查，转，退操作*/
	public void control(User user) {
		System.out.println("办理相应的业务！");
		System.out.println("1、存钱");
		System.out.println("2、取钱");
		System.out.println("3、查询余额");
		System.out.println("4、转账");
		System.out.println("5、退出");
		int flag = input.nextInt(); //flag用来判断用户选择需要服务的类型
		while (flag != 1 && flag != 2 && flag != 3 && flag != 4 && flag != 5)
		{
			System.out.println("请输入上述已有的序号:");
			flag = input.nextInt();
		}
		switch(flag) {
			case 1://存钱
				System.out.println("请输入你要存的金额:");
				String money1 = input.next();
				double money;
				/*允许输入的金额只能是大于0的数字*/
				if(isNum(money1) && Double.parseDouble(money1) > 0) {
					money = Double.valueOf(money1);//将String的money转成double型
					udi.save(user,money);
					System.out.println("存钱成功！");
				}else {
					System.out.println("请输入大于0的数字！！！！");
				}
				control(user);
				break;

			case 2://取钱
				System.out.println("请输入您要取的金额:");
				money1 = input.next();

				/*允许输入的金额只能是大于0的数字*/
				if(isNum(money1) && Double.parseDouble(money1) > 0 
					&& Double.parseDouble(money1) <= user.getMoney()) {
					money = Double.valueOf(money1);//将String的money转成double型
					udi.getMoney(user,money);
					System.out.println("取钱成功！");
				}else {
					System.out.println("您的操作不合理！！");
				}
				control(user);
				break;
			case 3://查询余额
				udi.checkBalance(user);
				control(user);
				break;
			case 4://转账
				System.out.println("请输入您要转的账户名:");
				String name = input.next();
				System.out.println("请输入您要转的金额:");
				money1 = input.next();
				/*允许输入的金额只能是大于0的数字*/
				if(isNum(money1) && Double.parseDouble(money1) > 0 
					&& Double.parseDouble(money1) <= user.getMoney()) {
					money = Double.valueOf(money1);//将String的money转成double型
					udi.transfer(user,name,money);
					System.out.println("转账成功！");
				}else {
					System.out.println("您的操作不合理！！" );
					
				}
				control(user);
				break;
			case 5://退出
				udi.quit();
				break;
		}

	}
	/*判断一个字符串是不是数字*/
	public boolean isNum(String str) {
		try{
			double num = Double.valueOf(str);//将字符串强制转成double类型
			return true;
		} catch(Exception e) {
			return false;
			
		}
		
	}
}