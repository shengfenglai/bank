


package com.cx.bank.frame;

import com.cx.bank.po.User;
import com.cx.bank.service.impl.UserServiceImpl;
import com.cx.bank.frame.RegisterFrame;
import com.cx.bank.frame.LoginFrame;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 设置欢迎界面
 */

public class WelcomeFrame extends JFrame implements ActionListener
{
	private JFrame jframe;  //窗体
	private JLabel usernameLabel;  //用户名标签
	private JLabel passwordLabel;  //密码标签
	private JTextField usernameField;  //用户名文本域
	private JPasswordField passwordField;  //密码文本域
	private JButton  regButton;    //注册按钮
	private JButton  loginButton; //登陆按钮
	private JButton resetButton; //重置按钮
	private String username;  //用来放文本域拿到的用户名
	private String password;  //用来放文本域拿到的密码
	private UserServiceImpl usi;//创建UserServiceImpl对象
	private User user = null;//user对象
	/*界面显示方法*/
	public void welcomeShow() {
		jframe = new JFrame();
		usernameLabel = new JLabel("用户名:");
		passwordLabel = new JLabel("密    码:");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		regButton = new JButton("注册");
		loginButton = new JButton("登陆");
		resetButton = new JButton("重置");

		jframe.setSize(400, 250);  //设置边框大小
		jframe.setLocationRelativeTo(null); // 让窗体居中显示 
		jframe.setTitle("欢迎进入XXXX银行系统");  //设置标题
		jframe.setResizable(false);   //设置为不能改变界面大小
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗口关闭,并退出程序
		jframe.setVisible(true);  //设置为可见
		
		
		Container container = jframe.getContentPane();
		container.setLayout(null);
		((JPanel) container).setOpaque(false);//设置控件透明
		
		//设置位置--------------------------------
		usernameLabel.setBounds(70,50,50,30);
		passwordLabel.setBounds(70,120,50,30);
		usernameField.setBounds(130,50,180,30);
		passwordField.setBounds(130,120,180,30);
		regButton.setBounds(60,180,70,22);
		loginButton.setBounds(170,180,70,22);
		resetButton.setBounds(280,180,70,22);

		//添加到界面------------------------------
		jframe.add(usernameLabel);
		jframe.add(passwordLabel);
		jframe.add(usernameField);  
		jframe.add(passwordField);  
		jframe.add(regButton);  
		jframe.add(loginButton);
		jframe.add(resetButton);

		//注册监听-------
		regButton.addActionListener(this);
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		String msg = "";
		//点击注册按钮
		if(e.getSource()==regButton) {
			new RegisterFrame().reg();
			jframe.setVisible(false);  //设置为不可见
		}
		//点击登陆按钮
		if(e.getSource()==loginButton) {
			username = usernameField.getText().trim();
			password = passwordField.getText().trim();
			if("".equals(username) || "".equals(password)) {
				msg = "存在空选项，无法提交！";
				JOptionPane.showMessageDialog(null, msg, "温馨提示",JOptionPane.ERROR_MESSAGE);
			} else {
				usi = UserServiceImpl.getInstance();
				user = usi.log(username,password);
				if("用户名不存在！".equals(user.getUsername()) || "用户名密码错误！".equals(user.getUsername())) {
					JOptionPane.showMessageDialog(null, user.getUsername(), "温馨提示",JOptionPane.ERROR_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "登陆成功！！");
					new LoginFrame(user);//把user传到登陆成功之后的操作界面
					jframe.setVisible(false);  //设置为不可见
				}
			}
		}

		//点击重置按钮
		if(e.getSource()==resetButton) {
			usernameField.setText("");//用户名文本域设置为空
			passwordField.setText("");//密码文本域设置为空
		}
	}	
}