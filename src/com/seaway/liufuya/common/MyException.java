package com.seaway.liufuya.common;

/**
 * 抛出该子类的异常，会自动被 MyErrorHandler 处理
 * @author 刘立立
 *
 */
public  class MyException extends RuntimeException {
	private static final long serialVersionUID = -1096970905084026855L;

	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
