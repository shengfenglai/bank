


package com.cx.bank.frame;

import com.cx.bank.service.impl.UserServiceImpl;
import com.cx.bank.frame.WelcomeFrame;
import com.cx.bank.util.IsNum;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import com.cx.bank.service.impl.UserServiceImpl;
		
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 负责银行帐号的注册
 */

public class RegisterFrame extends Frame implements ActionListener
{
	private JFrame jframe;    //窗体
	private JLabel usernameLabel;  //用户名标签
	private JLabel passwordLabel;  //密码标签
	private JLabel moneyLabel;     //金额标签
	private JTextField usernameField;  //用户名文本域
	private JPasswordField passwordField;  //密码文本域
	private JTextField moneyField;  //金额文本域
	private JButton  submitButton; //提交按钮
	private JButton resetButton; //重置按钮

	/*---------注册----------*/
	public void reg() {
		/*----------创建对象------------*/
		jframe = new JFrame();
		usernameLabel = new JLabel("用户名 :");
		passwordLabel = new JLabel("密    码 :");
		moneyLabel = new JLabel("金   额 :");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		moneyField = new JTextField();
		submitButton = new JButton("提交");
		resetButton = new JButton("重置");
		/*-------------初始化界面-----------*/
		jframe.setSize(300,400);
		jframe.setLocationRelativeTo(null); // 让窗体居中显示 
		jframe.setTitle("注册");  //设置标题
		jframe.setResizable(false);   //设置为不能改变界面大小
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗口关闭,并退出程序
		jframe.setVisible(true);  //设置为可见
		Container container = jframe.getContentPane();
		container.setLayout(null);
		((JPanel) container).setOpaque(false);//设置控件透明
		moneyField.setText(10 + "");
		moneyField.setEditable(false);

		/*---------设置各个组件大小----------*/
		usernameLabel.setBounds(40,60,50,30);
		passwordLabel.setBounds(40,140,50,30);
		moneyLabel.setBounds(40,220,50,30);
		usernameField.setBounds(100,60,140,30);
		passwordField.setBounds(100,140,140,30);
		moneyField.setBounds(100,220,140,30);
		submitButton.setBounds(45,300,70,35);
		resetButton.setBounds(180,300,70,35);

		/*------------添加组件--------------*/
		jframe.add(usernameLabel);
		jframe.add(passwordLabel);
		jframe.add(moneyLabel);
		jframe.add(usernameField);
		jframe.add(passwordField);
		jframe.add(moneyField);
		jframe.add(submitButton);
		jframe.add(resetButton);
		

		
		/*--------------注册监听-------*/
		submitButton.addActionListener(this);
		resetButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//点击提交按钮
		String msg = "";
		if(e.getSource() == submitButton){
			UserServiceImpl usi = UserServiceImpl.getInstance();//UserServiceImpl对象
			String username = usernameField.getText().trim();
			String password = passwordField.getText().trim();
			double	money = Double.parseDouble(moneyField.getText().trim());			
			if("".equals(username) || "".equals(password)) {
				msg = "存在空选项，无法提交！";
				JOptionPane.showMessageDialog(null, msg, "温馨提示",JOptionPane.ERROR_MESSAGE);
			}else {
				//判断密码是不是一个六位数的数字
				if(new IsNum().isNum(password) && password.length() == 6) {
					msg = usi.reg(username,password,money);//注册
					if("注册成功！".equals(msg)) {
						JOptionPane.showMessageDialog(null, msg);
						new WelcomeFrame().welcomeShow();//注册成功后弹到登陆界面
						jframe.setVisible(false);  //设置为不可见
					}
					if("该用户已经存在，注册不成功！".equals(msg)) {
						JOptionPane.showMessageDialog(null, msg, "温馨提示",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					msg = "密码不是一个六位数的数字！！";
					JOptionPane.showMessageDialog(null, msg, "温馨提示",JOptionPane.ERROR_MESSAGE);
				}	
			}	
		}

		//点击重置按钮
		if(e.getSource() == resetButton) {
			usernameField.setText("");
			passwordField.setText("");
		}
	}

}