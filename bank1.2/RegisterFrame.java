


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
 * @TODO ���������ʺŵ�ע��
 */

public class RegisterFrame extends Frame implements ActionListener
{
	private JFrame jframe;    //����
	private JLabel usernameLabel;  //�û�����ǩ
	private JLabel passwordLabel;  //�����ǩ
	private JLabel moneyLabel;     //����ǩ
	private JTextField usernameField;  //�û����ı���
	private JPasswordField passwordField;  //�����ı���
	private JTextField moneyField;  //����ı���
	private JButton  submitButton; //�ύ��ť
	private JButton resetButton; //���ð�ť

	/*---------ע��----------*/
	public void reg() {
		/*----------��������------------*/
		jframe = new JFrame();
		usernameLabel = new JLabel("�û��� :");
		passwordLabel = new JLabel("��    �� :");
		moneyLabel = new JLabel("��   �� :");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		moneyField = new JTextField();
		submitButton = new JButton("�ύ");
		resetButton = new JButton("����");
		/*-------------��ʼ������-----------*/
		jframe.setSize(300,400);
		jframe.setLocationRelativeTo(null); // �ô��������ʾ 
		jframe.setTitle("ע��");  //���ñ���
		jframe.setResizable(false);   //����Ϊ���ܸı�����С
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������ڹر�,���˳�����
		jframe.setVisible(true);  //����Ϊ�ɼ�
		Container container = jframe.getContentPane();
		container.setLayout(null);
		((JPanel) container).setOpaque(false);//���ÿؼ�͸��
		moneyField.setText(10 + "");
		moneyField.setEditable(false);

		/*---------���ø��������С----------*/
		usernameLabel.setBounds(40,60,50,30);
		passwordLabel.setBounds(40,140,50,30);
		moneyLabel.setBounds(40,220,50,30);
		usernameField.setBounds(100,60,140,30);
		passwordField.setBounds(100,140,140,30);
		moneyField.setBounds(100,220,140,30);
		submitButton.setBounds(45,300,70,35);
		resetButton.setBounds(180,300,70,35);

		/*------------������--------------*/
		jframe.add(usernameLabel);
		jframe.add(passwordLabel);
		jframe.add(moneyLabel);
		jframe.add(usernameField);
		jframe.add(passwordField);
		jframe.add(moneyField);
		jframe.add(submitButton);
		jframe.add(resetButton);
		

		
		/*--------------ע�����-------*/
		submitButton.addActionListener(this);
		resetButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//����ύ��ť
		String msg = "";
		if(e.getSource() == submitButton){
			UserServiceImpl usi = UserServiceImpl.getInstance();//UserServiceImpl����
			String username = usernameField.getText().trim();
			String password = passwordField.getText().trim();
			double	money = Double.parseDouble(moneyField.getText().trim());			
			if("".equals(username) || "".equals(password)) {
				msg = "���ڿ�ѡ��޷��ύ��";
				JOptionPane.showMessageDialog(null, msg, "��ܰ��ʾ",JOptionPane.ERROR_MESSAGE);
			}else {
				//�ж������ǲ���һ����λ��������
				if(new IsNum().isNum(password) && password.length() == 6) {
					msg = usi.reg(username,password,money);//ע��
					if("ע��ɹ���".equals(msg)) {
						JOptionPane.showMessageDialog(null, msg);
						new WelcomeFrame().welcomeShow();//ע��ɹ��󵯵���½����
						jframe.setVisible(false);  //����Ϊ���ɼ�
					}
					if("���û��Ѿ����ڣ�ע�᲻�ɹ���".equals(msg)) {
						JOptionPane.showMessageDialog(null, msg, "��ܰ��ʾ",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					msg = "���벻��һ����λ�������֣���";
					JOptionPane.showMessageDialog(null, msg, "��ܰ��ʾ",JOptionPane.ERROR_MESSAGE);
				}	
			}	
		}

		//������ð�ť
		if(e.getSource() == resetButton) {
			usernameField.setText("");
			passwordField.setText("");
		}
	}

}