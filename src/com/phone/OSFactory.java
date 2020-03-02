package com.phone;

public class OSFactory {

	public static OS getInstance(String name) throws ClassNotFoundException {

		switch (name.toLowerCase()) {
			case "android":
				return new Android();
			case "ios":
				return new IOS();
			case "windows":
				return new Windows();
			default:
				throw new ClassNotFoundException("OS not recognized");
		}

	}

}
