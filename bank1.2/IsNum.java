



package com.cx.bank.util;
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO �����࣬�����ж�һ���ַ����ǲ�������
 */

 public class IsNum
 {
	 public boolean isNum(String str) {
		try{
			double num = Double.valueOf(str);//���ַ���ǿ��ת��double����
			return true;
		} catch(Exception e) {
			return false;
			
		}
		
	}
 }