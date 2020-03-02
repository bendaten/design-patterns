package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Youtube {

	List<Subject> channels;

	private static Youtube instance = null;

	private Youtube() {
		channels = new ArrayList<>();
	}

	public static Youtube getInstance() {
		if (instance == null) {
			instance = new Youtube();
		}

		return instance;
	}

	public void addChannel(Subject channel) {
		channels.add(channel);
	}

}
