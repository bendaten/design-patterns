package com.observer;

public interface Observer {

	void update(String channelName, String title);

	void subscribeToChannel(Subject channel);

	void unsubscribeFromChannel(Subject channel);

}
