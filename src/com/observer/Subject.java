package com.observer;

public interface Subject {
	void subscribe(Observer subscriber);

	void unsubscribe(Observer subscriber);

	void notifySubscribers(String title);

	void upload(String title);
}
