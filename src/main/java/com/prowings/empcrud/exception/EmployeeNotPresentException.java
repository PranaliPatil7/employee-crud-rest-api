package com.prowings.empcrud.exception;

public class EmployeeNotPresentException extends Exception {
	String msg;

	public EmployeeNotPresentException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
}
