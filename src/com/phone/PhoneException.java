package com.phone;

public class PhoneException extends Exception {

	public PhoneException(String message) {
		super("#### Error: " + message);
	}

}
