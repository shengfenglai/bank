



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
 * @TODO ��������ϵͳ��½�ɹ�֮��Ĳ�ѯ���
 */
public class CheckMoneyFrame extends Frame implements ActionListener 
{
	 private  JFrame jframe;  //������
	 private JLabel textLabel; //��ǩ
	 private JTextField text; //�ı���
	 private JButton returnButton;//�������˵�
	 private User user; //user����
	 private UserServiceImpl usi = UserServiceImpl.getInstance();
	 double money;//��ʾ���
	//�����ʼ��
	 public CheckMoneyFrame(User user){
		 
		/*��������*/
		jframe = new JFrame();
		textLabel = new JLabel("�������Ϊ: ");
		text  = new JTextField();
		returnButton = new JButton("�������˵�");
		this.user = user;  //�����user���ǵ�ǰ��¼�û���user
		/*�������*/
		jframe.setSize(400,300);
		jframe.setLocationRelativeTo(null); // �ô��������ʾ 
		jframe.setTitle("ȡǮ");  //���ñ���
		jframe.setResizable(false);   //����Ϊ���ܸı�����С
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������ڹر�,���˳�����
		jframe.setVisible(true);  //����Ϊ�ɼ�
		Container container = jframe.getContentPane();
		container.setLayout(null);
		((JPanel) container).setOpaque(false);//���ÿؼ�͸��

		text.setEditable(false);
		
		textLabel.setBounds(160,30,130,30);
		text.setBounds(140,70,130,30);
		returnButton.setBounds(140,150,130,35);
		

		/*������*/
		jframe.add(textLabel);
		jframe.add(text);
		jframe.add(returnButton);
		
		/*ע�����*/
		returnButton.addActionListener(this);

		/*��ʾ���*/
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