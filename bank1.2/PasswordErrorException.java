




package com.cx.bank.exception;


/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 密码错误的自定义异常
 */
public class PasswordErrorException extends RuntimeException {
	public PasswordErrorException(String msg) {
		super(msg);
	}
}