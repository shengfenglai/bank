


package com.cx.bank.frame;

import com.cx.bank.po.User;
import com.cx.bank.service.impl.UserServiceImpl;
import com.cx.bank.frame.LoginFrame;
import com.cx.bank.util.IsNum;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 负责银行系统登陆成功之后的转账
 */
public class TransferMoneyFrame extends Frame implements ActionListener
{
    private  JFrame jframe;  //主窗体
	private JLabel usernameLabel; //转给用户的标签
	private JTextField usernameField; //用户名文本域
	private JLabel moneyLabel; //转给用户的标签
	private JTextField moneyField; //用户名文本域
	private JButton submitButton;//确定按钮
	private JButton cancelButton;//取消按钮
	private JButton resetButton; //重置按钮
	private double money; //接收文本域的参数作为输入的金额
	private String name;//接收文本域的参数作为用户名
	private User user; //user对象
	private UserServiceImpl usi = UserServiceImpl.getInstance();
	//组件初始化
	public TransferMoneyFrame(User user){
		 
		/*创建对象*/
		jframe = new JFrame();
		usernameLabel = new JLabel("请输入您要转的用户名 : ");
		usernameField  = new JTextField();
		moneyLabel = new JLabel("请输入您要转的金额 : ");
		moneyField  = new JTextField();
		submitButton = new JButton("确定");
		cancelButton = new JButton("取消");
		resetButton = new JButton("重置");
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
		
		usernameLabel.setBounds(140,30,200,30);
		usernameField.setBounds(120,70,180,30);
		moneyLabel.setBounds(140,110,200,30);
		moneyField.setBounds(120,150,180,30);
		submitButton.setBounds(70,210,70,35);
		cancelButton.setBounds(170,210,70,35);
		resetButton.setBounds(270,210,70,35);

		/*添加组件*/
		jframe.add(usernameLabel);
		jframe.add(usernameField);
		jframe.add(moneyLabel);
		jframe.add(moneyField);
		jframe.add(submitButton);
		jframe.add(cancelButton);
		jframe.add(resetButton);
		
		/*注册监听*/
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
		resetButton.addActionListener(this);
		
	
	 }

	 public void actionPerformed(ActionEvent e) {
		 
		//点击确定按钮
		 if(e.getSource() == submitButton) {
			String msg = "";
			if("".equals(usernameField.getText().trim()) || "".equals(moneyField.getText().trim())) {
				msg = "存在空选项，无法提交！";
				JOptionPane.showMessageDialog(null,msg , "温馨提示",JOptionPane.ERROR_MESSAGE);
			} else {
				name = usernameField.getText().trim();
				money = Double.parseDouble(moneyField.getText().trim());
				if(new IsNum().isNum(moneyField.getText().trim())) {
					if(money > 0){
						if(money < user.getMoney()) {
							msg = usi.transfer(user,name,money);
							if ("转账成功！".equals(msg)){
								JOptionPane.showMessageDialog(null, "转账成功！！");
								jframe.setVisible(false);
								new LoginFrame(user);
							}

							if("您要转的账户不存在!".equals(msg)) {
								JOptionPane.showMessageDialog(null,msg , "温馨提示",JOptionPane.ERROR_MESSAGE);
							}
						} else {
							msg = "余额不足！！";
							JOptionPane.showMessageDialog(null,msg , "温馨提示",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						msg = "金额必须大于0！！";
						JOptionPane.showMessageDialog(null,msg , "温馨提示",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					msg = "您输入的不是一个数字！";
					JOptionPane.showMessageDialog(null,msg , "温馨提示",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			

		 }

		 //点击取消按钮
		 if(e.getSource() == cancelButton) {
			jframe.setVisible(false);
			new LoginFrame(user);
			
		 }

		 //点击重置按钮
		 if(e.getSource() == resetButton) {
			usernameField.setText("");
			moneyField.setText("");
		 }
		
	 }
}