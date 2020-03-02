package com.composite;

public class Leaf implements Component {

	private double price;
	private String name;

	public Leaf(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%s is $%.2f", name, this.getPrice());
	}

	@Override
	public String spec() {
		return this.toString();
	}
}
