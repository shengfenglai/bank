



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
 * @TODO ��������ϵͳ��½�ɹ�֮��ĸ��ֲ���
 */
public class LoginFrame extends Frame implements ActionListener
{
	private JFrame jframe;//������
	private JButton saveButton;//��Ǯ��ť
	private JButton getButton;//ȡǮ��ť
	private JButton checkButton;//��ѯ��ť
	private JButton transferButton;//תǮ��ť
	private JButton exitButton;//�˳���ť
	private JPanel panel;//һ��panel
	private JTextField text;//һ���ı���
	private JLabel textLabel;//�ı����ǩ
	private User user = null;
	/*��ʼ��*/
	public LoginFrame(User user) {
		/*----------��������------------*/
		jframe = new JFrame();
		saveButton = new JButton("��Ǯ");
		getButton = new JButton("ȡǮ");
		checkButton = new JButton("��ѯ");
		transferButton = new JButton("ת��");
		exitButton = new JButton("�˳�");
		panel = new JPanel();
		text = new JTextField();
		this.user = user;  //�����user���ǵ�ǰ��¼�û���user

		/*-------------��ʼ������-----------*/
		jframe.setSize(600,400);
		jframe.setLocationRelativeTo(null); // �ô��������ʾ 
		jframe.setTitle("ҵ�����");  //���ñ���
		jframe.setResizable(false);   //����Ϊ���ܸı�����С
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������ڹر�,���˳�����
		jframe.setVisible(true);  //����Ϊ�ɼ�
		Container container = jframe.getContentPane();
		container.setLayout(null);
		((JPanel) container).setOpaque(false);//���ÿؼ�͸��
		
		
		/*---------���ø��������С----------*/
		saveButton.setBounds(25,310,70,35);
		getButton.setBounds(145,310,70,35);
		checkButton.setBounds(265,310,70,35);
		transferButton.setBounds(385,310,70,35);
		exitButton.setBounds(505,310,70,35);
		

		/*------------������--------------*/
		jframe.add(saveButton);
		jframe.add(getButton);
		jframe.add(checkButton);
		jframe.add(transferButton);
		jframe.add(exitButton);
		
		
		/*--------------ע�����-------*/
		saveButton.addActionListener(this);
		getButton.addActionListener(this);
		checkButton.addActionListener(this);
		transferButton.addActionListener(this);
		exitButton.addActionListener(this);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		/*--------�����Ǯ------------*/
		if(e.getSource() == saveButton) {
			new SaveMoneyFrame(user);
			jframe.setVisible(false);
			
		}
		/*--------���ȡǮ------------*/
		
		if(e.getSource() == getButton) {
			new GetMoneyFrame(user);
			jframe.setVisible(false);
		}

		/*--------�����ѯ------------*/
		if(e.getSource() == checkButton) {
			jframe.setVisible(false);
			new CheckMoneyFrame(user);

		}
		/*--------���ת��------------*/
		if(e.getSource() == transferButton) {
			jframe.setVisible(false);
			new TransferMoneyFrame(user);

		}
		/*--------����˳�------------*/
		if(e.getSource() == exitButton) {
			System.exit(1);
		}
	}
	
}