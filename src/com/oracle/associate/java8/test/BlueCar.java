package com.oracle.associate.java8.test;

abstract class Car {
	static { System.out.println("1"); }
	public Car(String name) {
		super();
		System.out.println("2");
	}
	{ System.out.println("3"); }
}

public class BlueCar extends Car {
	{ System.out.println("4"); }
	public BlueCar() {
		super("blue");
		System.out.println("5");
	}
	public static void main(String[] gears) {
		new BlueCar();
	}
}
