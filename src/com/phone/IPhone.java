package com.phone;

import javax.xml.crypto.OctetStreamData;

public class IPhone implements Phone {

	private String name;
	private OS os;
	private double screenSize;
	private int batteryLifeMin;
	private String processor;
	private int cameraPixels;

	public IPhone(double screenSize, int batteryLifeMin, String processor, int cameraPixels) {
		try {
			this.os = OSFactory.getInstance("ios");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		this.name = "iPhone X";
		this.screenSize = screenSize;
		this.batteryLifeMin = batteryLifeMin;
		this.processor = processor;
		this.cameraPixels = cameraPixels;
	}

	@Override
	public String spec() {
		double megapixels = cameraPixels / 1e6;
		return String.format("name = %s%n  screen size = %f in%n  processor = %s%n  battery life = %d min%n  camera = %f%n  OS = %s",
				name, screenSize, processor, batteryLifeMin, megapixels, os.spec());
	}

}
