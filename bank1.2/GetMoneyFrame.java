


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
 * @TODO ��������ϵͳ��½�ɹ�֮���ȡǮ
 */
 public class GetMoneyFrame extends Frame implements ActionListener
 {
	 private  JFrame jframe;  //������
	 private JLabel textLabel; //��ǩ
	 private JTextField text; //�ı���
	 private JButton submitButton;//ȷ����ť
	 private JButton cancelButton;//ȡ����ť
	 private JButton resetButton; //���ð�ť
	 private double money; //�����ı���Ĳ�����Ϊ����Ľ��
	 private User user; //user����
	 private UserServiceImpl usi = UserServiceImpl.getInstance();
	 //�����ʼ��
	 public GetMoneyFrame(User user){
		 
		/*��������*/
		jframe = new JFrame();
		textLabel = new JLabel("����������ȡ���� : ");
		text  = new JTextField();
		submitButton = new JButton("ȷ��");
		cancelButton = new JButton("ȡ��");
		resetButton = new JButton("����");
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
		
		textLabel.setBounds(140,30,200,30);
		text.setBounds(120,70,180,30);
		submitButton.setBounds(70,150,70,35);
		cancelButton.setBounds(170,150,70,35);
		resetButton.setBounds(270,150,70,35);

		/*�������*/
		jframe.add(textLabel);
		jframe.add(text);
		jframe.add(submitButton);
		jframe.add(cancelButton);
		jframe.add(resetButton);
		
		/*ע�����*/
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
		resetButton.addActionListener(this);
		
	
	 }

	 public void actionPerformed(ActionEvent e) {
		 
		//���ȷ����ť
		 if(e.getSource() == submitButton) {
			if(new IsNum().isNum(text.getText().trim())) {
				money = Double.parseDouble(text.getText().trim());
				if(money > 0) {
					if(money <= user.getMoney()) {
						usi.get(user,money);
						JOptionPane.showMessageDialog(null, "ȡ��ɹ�����");
						jframe.setVisible(false);
						new LoginFrame(user);
					}else {
						JOptionPane.showMessageDialog(null, "���㣡��", "��ܰ��ʾ",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "���������0����", "��ܰ��ʾ",JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "�����������֣���", "��ܰ��ʾ",JOptionPane.ERROR_MESSAGE);
			}
			
			

		 }

		 //���ȡ����ť
		 if(e.getSource() == cancelButton) {
			jframe.setVisible(false);
			new LoginFrame(user);
			
		 }

		 //������ð�ť
		 if(e.getSource() == resetButton) {
			text.setText("");
		 }
		
	 }

	

	
 }