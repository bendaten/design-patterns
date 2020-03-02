package com.bendaten.designpatterns;

import com.adapter.Assignment;
import com.adapter.Course;
import com.adapter.CourseException;
import com.adapter.PenAdapter;
import com.composite.Component;
import com.composite.Composite;
import com.composite.Leaf;
import com.observer.*;
import com.phone.OSFactory;
import com.phone.Phone;
import com.phone.PhoneBuilder;
import com.phone.PhoneException;
import com.prototype.BookStore;

public class DesignPatternsMain {

	private static void print(String input) {
		System.out.println(input);
	}  // SonarLint warning just here

	private static final String HORIZONTAL_LINE = "==================================================================\n";

	public static void main(String[] args) {

		// Factory
		print("In main");
		try {
			print(OSFactory.getInstance("android").spec());
			print(OSFactory.getInstance("ios").spec());
			print(OSFactory.getInstance("windows").spec());
			print(OSFactory.getInstance("unknown").spec());
		} catch (ClassNotFoundException e) {
			print(e.getMessage());
		}

		// Builder
		PhoneBuilder pb = new PhoneBuilder();
		Phone myPhone;
		try {
			myPhone = pb.build();  // expected to fail - no fields are set yet
			print(myPhone.spec());
		} catch (ClassNotFoundException | PhoneException e) {
			print(e.getMessage());
		}
		try {
			myPhone = pb.setName("yossi")
					.setBatteryLifeMin(555)
					.setScreenSize(6.7)
					.setCameraPixels(16000000)
					.build();  // expected to fail - still processor field is not set
			print(myPhone.spec());
		} catch (ClassNotFoundException | PhoneException e) {
			print(e.getMessage());
		}
		try {
			myPhone = pb.setProcessor("Quantum4")
					.build();  // expected to fail - phone 'yossi' does not exist
			print(myPhone.spec());
		} catch (ClassNotFoundException | PhoneException e) {
			print(e.getMessage());
		}
		try {
			myPhone = pb.setName("iphone").build();  // now ok
			print(myPhone.spec());
		} catch (ClassNotFoundException | PhoneException e) {
			print(e.getMessage());
		}

		pb.reset();  // back to factory setting
		try {
			myPhone = pb.setName("nokia")
					.setBatteryLifeMin(666)
					.setScreenSize(5.7)
					.setCameraPixels(12000000)
					.setProcessor("Plombium6")
					.build();  // expected to fail - Nokia needs the os field set
			print(myPhone.spec());
		} catch (ClassNotFoundException | PhoneException e) {
			print(e.getMessage());
		}
		try {
			myPhone = pb.setOs("windows").build();  // now ok
			print(myPhone.spec());
		} catch (ClassNotFoundException | PhoneException e) {
			print(e.getMessage());
		}

		print("\n");

		// adapter
		Course analyticalMethods;
		try {
			analyticalMethods = new Course("Analytical Methods", 3);
			print(analyticalMethods.transcript());
		} catch (CourseException e) {
			print(e.getMessage());
			return;
		}
		print(HORIZONTAL_LINE);

		Assignment as1 = new Assignment("Assignment 1");
		as1.setPen(new PenAdapter());
		try {
			as1.write("This is the text of the first assignment");
			analyticalMethods.submitAssignment(as1);
			print(analyticalMethods.readAssignment(-1));
			analyticalMethods.gradeAssignment(-1, 88);
			print(analyticalMethods.transcript());
		} catch (CourseException e) {
			print(e.getMessage());
		}
		print(HORIZONTAL_LINE);

		Assignment as2 = new Assignment("Assignment 2");
		as2.setPen(new PenAdapter());
		try {
			as2.write("This is the text of the second assignment. This time I hope it will be graded higher.");
			analyticalMethods.submitAssignment(as2);
			print(analyticalMethods.readAssignment(-1));
			analyticalMethods.gradeAssignment(-1, 77);
		} catch (CourseException e) {
			print(e.getMessage());
		}
		print(HORIZONTAL_LINE);

		Assignment as3 = new Assignment("Assignment 3");
		as3.setPen(new PenAdapter());
		try {
			as3.write("This is the text of the last assignment. Lost hope of an A");
			analyticalMethods.submitAssignment(as3);
			analyticalMethods.gradeAssignment(-1, 95);
			print(analyticalMethods.transcript());
		} catch (CourseException e) {
			print(e.getMessage());
		}
		print(HORIZONTAL_LINE);

		// Composite
		Composite computer = new Composite("computer", 0.0);
		Composite computerCase = new Composite("case", 49.99);
		computer.addComponent(computerCase);
		Composite motherBoard = new Composite("motherboard", 179.99);
		computerCase.addComponent(motherBoard);
		Component cpu = new Leaf("CPU", 249.99);
		motherBoard.addComponent(cpu);
		Component ram = new Leaf("RAM", 229.99);
		motherBoard.addComponent(ram);
		Component hardDrive = new Leaf("hard drive", 99.99);
		computerCase.addComponent(hardDrive);
		Composite peripherals = new Composite("peripherals", 0.0);
		computer.addComponent(peripherals);
		Component monitor = new Leaf("monitor", 179.99);
		peripherals.addComponent(monitor);
		Component mouse = new Leaf("mouse", 19.99);
		peripherals.addComponent(mouse);
		Component keyboard = new Leaf("keyboard", 29.99);
		peripherals.addComponent(keyboard);

		print(computer.spec());
		print(HORIZONTAL_LINE);

		// Prototype
		BookStore prototype = new BookStore("proto", "doesn't matter");
		prototype.loadData();

		BookStore bs1 = new BookStore("Tasty", "123 El Tuta Dr., San Yossi, CP", prototype);
		print(bs1.toString());

		BookStore bs2 = new BookStore("Novelty", "456 Haim Street, Moshe City, YK", prototype);
		print(bs2.toString());

		print(HORIZONTAL_LINE);

		// Observer
		Youtube youtube = Youtube.getInstance();
		Subject theFlightophile = new Channel("The Flightophile");
		youtube.addChannel(theFlightophile);

		Observer me = new Subscriber("Daniel");
		Observer you = new Subscriber("Haim");
		Observer him = new Subscriber("Moshe");
		Observer her = new Subscriber("Sonia");
		Observer zi = new Subscriber("Dudu");

		me.subscribeToChannel(theFlightophile);
		you.subscribeToChannel(theFlightophile);
		him.subscribeToChannel(theFlightophile);
		her.subscribeToChannel(theFlightophile);
		zi.subscribeToChannel(theFlightophile);

		theFlightophile.upload("How to Loose a Guy in 10 Days");
		print(HORIZONTAL_LINE);

		him.unsubscribeFromChannel(theFlightophile);

		theFlightophile.upload("Gods Must be Crazy");

	}

}
