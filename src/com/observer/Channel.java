package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

	private String name;
	private List<Observer> subscribers;

	public Channel(String name) {
		this.name = name;
		subscribers = new ArrayList<>();
	}

	@Override
	public void subscribe(Observer subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void unsubscribe(Observer subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void notifySubscribers(String title) {
		for (Observer s : subscribers) {
			s.update(name, title);
		}
	}

	@Override
	public void upload(String title) {
		notifySubscribers(title);
	}

}
