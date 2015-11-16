



package com.cx.bank.message; 
import com.cx.bank.model.User;
/**
 * @author laishengfeng
 * @version  bank 1.1
 * @TODO UserService接口,提供方法给实现类实现
 */
public interface UserService
{
	public void entry();//进入银行注册或登陆界面
	public void control(User user);//登陆成功之后进行存，取，查，转，退操作
}