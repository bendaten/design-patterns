package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements Observer {

	private String name;
	private List<Subject> channels;

	public Subscriber(String name) {
		this.name = name;
		channels = new ArrayList<>();
	}

	@Override
	public void update(String channelName, String title) {
		System.out.println(String.format("%s, the title \"%s\" was uploaded to the channel %s you are subscribed to",
				name, title, channelName));
	}

	@Override
	public void subscribeToChannel(Subject channel) {
		channels.add(channel);
		channel.subscribe(this);
	}

	@Override
	public void unsubscribeFromChannel(Subject channel) {
		channels.remove(channel);
		channel.unsubscribe(this);
	}

}
