



package com.cx.bank.frame;

import com.cx.bank.po.User;
import com.cx.bank.frame.SaveMoneyFrame;
import com.cx.bank.frame.GetMoneyFrame;
import com.cx.bank.frame.CheckMoneyFrame;
import com.cx.bank.frame.TransferMoneyFrame;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;		
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 负责银行系统登陆成功之后的各种操作
 */
public class LoginFrame extends Frame implements ActionListener
{
	private JFrame jframe;//主窗体
	private JButton saveButton;//存钱按钮
	private JButton getButton;//取钱按钮
	private JButton checkButton;//查询按钮
	private JButton transferButton;//转钱按钮
	private JButton exitButton;//退出按钮
	private JPanel panel;//一个panel
	private JTextField text;//一个文本域
	private JLabel textLabel;//文本域标签
	private User user = null;
	/*初始化*/
	public LoginFrame(User user) {
		/*----------创建对象------------*/
		jframe = new JFrame();
		saveButton = new JButton("存钱");
		getButton = new JButton("取钱");
		checkButton = new JButton("查询");
		transferButton = new JButton("转账");
		exitButton = new JButton("退出");
		panel = new JPanel();
		text = new JTextField();
		this.user = user;  //令这个user就是当前登录用户的user

		/*-------------初始化界面-----------*/
		jframe.setSize(600,400);
		jframe.setLocationRelativeTo(null); // 让窗体居中显示 
		jframe.setTitle("业务办理");  //设置标题
		jframe.setResizable(false);   //设置为不能改变界面大小
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗口关闭,并退出程序
		jframe.setVisible(true);  //设置为可见
		Container container = jframe.getContentPane();
		container.setLayout(null);
		((JPanel) container).setOpaque(false);//设置控件透明
		
		
		/*---------设置各个组件大小----------*/
		saveButton.setBounds(25,310,70,35);
		getButton.setBounds(145,310,70,35);
		checkButton.setBounds(265,310,70,35);
		transferButton.setBounds(385,310,70,35);
		exitButton.setBounds(505,310,70,35);
		

		/*------------添加组件--------------*/
		jframe.add(saveButton);
		jframe.add(getButton);
		jframe.add(checkButton);
		jframe.add(transferButton);
		jframe.add(exitButton);
		
		
		/*--------------注册监听-------*/
		saveButton.addActionListener(this);
		getButton.addActionListener(this);
		checkButton.addActionListener(this);
		transferButton.addActionListener(this);
		exitButton.addActionListener(this);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		/*--------点击存钱------------*/
		if(e.getSource() == saveButton) {
			new SaveMoneyFrame(user);
			jframe.setVisible(false);
			
		}
		/*--------点击取钱------------*/
		
		if(e.getSource() == getButton) {
			new GetMoneyFrame(user);
			jframe.setVisible(false);
		}

		/*--------点击查询------------*/
		if(e.getSource() == checkButton) {
			jframe.setVisible(false);
			new CheckMoneyFrame(user);

		}
		/*--------点击转账------------*/
		if(e.getSource() == transferButton) {
			jframe.setVisible(false);
			new TransferMoneyFrame(user);

		}
		/*--------点击退出------------*/
		if(e.getSource() == exitButton) {
			System.exit(1);
		}
	}
	
}