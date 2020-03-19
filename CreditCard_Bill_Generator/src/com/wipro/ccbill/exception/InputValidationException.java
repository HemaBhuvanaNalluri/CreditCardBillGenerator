package com.wipro.ccbill.exception;

@SuppressWarnings("serial")
public class InputValidationException extends Exception{
	
	public  InputValidationException(String str) {
		super(str);
		
	}
	
	
	@Override
	public String toString() {
		return "Invalid Data";
	}
}


