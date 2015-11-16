



package com.cx.bank.frame;

import com.cx.bank.po.User;
import com.cx.bank.service.impl.UserServiceImpl;
import com.cx.bank.frame.LoginFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 负责银行系统登陆成功之后的查询余额
 */
public class CheckMoneyFrame extends Frame implements ActionListener 
{
	 private  JFrame jframe;  //主窗体
	 private JLabel textLabel; //标签
	 private JTextField text; //文本域
	 private JButton returnButton;//返回主菜单
	 private User user; //user对象
	 private UserServiceImpl usi = UserServiceImpl.getInstance();
	 double money;//显示余额
	//组件初始化
	 public CheckMoneyFrame(User user){
		 
		/*创建对象*/
		jframe = new JFrame();
		textLabel = new JLabel("您的余额为: ");
		text  = new JTextField();
		returnButton = new JButton("返回主菜单");
		this.user = user;  //令这个user就是当前登录用户的user
		/*设置组件*/
		jframe.setSize(400,300);
		jframe.setLocationRelativeTo(null); // 让窗体居中显示 
		jframe.setTitle("取钱");  //设置标题
		jframe.setResizable(false);   //设置为不能改变界面大小
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗口关闭,并退出程序
		jframe.setVisible(true);  //设置为可见
		Container container = jframe.getContentPane();
		container.setLayout(null);
		((JPanel) container).setOpaque(false);//设置控件透明

		text.setEditable(false);
		
		textLabel.setBounds(160,30,130,30);
		text.setBounds(140,70,130,30);
		returnButton.setBounds(140,150,130,35);
		

		/*添加组件*/
		jframe.add(textLabel);
		jframe.add(text);
		jframe.add(returnButton);
		
		/*注册监听*/
		returnButton.addActionListener(this);

		/*显示余额*/
		money = user.getMoney();
		text.setText(money + "");
	 }

	 public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnButton) {
			jframe.setVisible(false);
			new LoginFrame(user);
			
		} 
	 }


	
}