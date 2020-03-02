package com.phone;

public class PhoneBuilder {

	private String name;
	private String os;
	private double screenSize;
	private int batteryLifeMin;
	private String processor;
	private int cameraPixels;

	public PhoneBuilder() {
		reset();
	}

	private boolean isNameSet() {
		return !name.isEmpty();
	}
	private boolean isOsSet() {
		return !os.isEmpty();
	}
	private boolean isProcessorSet() {
		return !processor.isEmpty();
	}
	private boolean isScreenSizeSet() {
		return screenSize > 0.0;
	}
	private boolean isBatteryLifeMinSet() {
		return batteryLifeMin > 0;
	}
	private boolean iscameraPixelsSet() {
		return cameraPixels > 0;
	}

	public PhoneBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}

	public PhoneBuilder setScreenSize(double screenSize) {
		this.screenSize = screenSize;
		return this;
	}

	public PhoneBuilder setBatteryLifeMin(int batteryLifeMin) {
		this.batteryLifeMin = batteryLifeMin;
		return this;
	}

	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}

	public PhoneBuilder setCameraPixels(int cameraPixels) {
		this.cameraPixels = cameraPixels;
		return this;
	}

	private void checkPropertySet(boolean isSet, String message) throws PhoneException {
		if (!isSet) {
			throw new PhoneException(message);
		}
	}

	public Phone build() throws ClassNotFoundException, PhoneException {

		checkPropertySet(isNameSet(), "Name must be set - use setName()");
		checkPropertySet(isScreenSizeSet(), "Screen size must be set - use setScreenSize()");
		checkPropertySet(isBatteryLifeMinSet(), "Battery life must be set - use setBatteryLifeMin()");
		checkPropertySet(isProcessorSet(), "Processor must be set - use setProcessor()");
		checkPropertySet(iscameraPixelsSet(), "Camera pixels must be set - use setCameraPixels()");
		switch (name.toLowerCase()) {
			case "iphone":
				return new IPhone(screenSize, batteryLifeMin, processor, cameraPixels);
			case "galaxy":
				return new Galaxy(screenSize, batteryLifeMin, processor, cameraPixels);
			case "nokia":
				checkPropertySet(isOsSet(), "OS type must be set - use setOs()");
				return new Nokia(os, screenSize, batteryLifeMin, processor, cameraPixels);
			default:
				throw new ClassNotFoundException("Phone type not found");
		}
	}

	public void reset() {
		name = "";
		os = "";
		screenSize = -1.0;
		batteryLifeMin = -1;
		processor = "";
		cameraPixels = -1;
	}

}
