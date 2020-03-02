package com.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

	private double price;
	private String name;

	List<Component> components;

	public Composite(String name, double price) {
		this.name = name;
		this.price = price;
		this.components = new ArrayList<>();
	}

	public void addComponent(Component component) {
		this.components.add(component);
	}

	@Override
	public double getPrice() {
		double calculatedPrice = this.price;
		for (Component component : components) {
			calculatedPrice += component.getPrice();
		}
		return calculatedPrice;
	}

	@Override
	public String toString() {
		return String.format("%s is $%.2f", name, this.getPrice());
	}

	@Override
	public String spec() {
		StringBuilder sb = new StringBuilder(name);
		sb.append(" is ").append(String.format("%.2f", this.price)).append("\n");
		double totoalPrice = this.price;
		for (Component component : this.components) {
			sb.append(component.spec()).append("\n");
			totoalPrice += component.getPrice();
		}
		sb.append(this.name).append(" total price - ").append(String.format("%.2f", totoalPrice)).append("\n");
		return sb.toString();
	}
}
