



package com.cx.bank.util;
/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 工具类，用来判断一个字符串是不是数字
 */

 public class IsNum
 {
	 public boolean isNum(String str) {
		try{
			double num = Double.valueOf(str);//将字符串强制转成double类型
			return true;
		} catch(Exception e) {
			return false;
			
		}
		
	}
 }