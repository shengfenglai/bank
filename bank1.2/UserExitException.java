

package com.cx.bank.exception;


/**
 * @author laishengfeng
 * @version  bank 1.2
 * @TODO 用户名已经存在的自定义异常
 */
public class UserExitException extends RuntimeException {
	public UserExitException(String msg) {
		super(msg);
	}
}