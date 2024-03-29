package com.oracle.java8.associate;

class Automobile {
	private final String drive() {
		return "Driving vehicle";
	}
}

class Car extends Auto {
	protected String drive() {
		return "Driving car";
	}
}

public class ElectricCar extends Car {
	@Override
	public final String drive() {
		return "Driving electric car";
	}
	
	public static void main(String[] args) {
		final Car car = new ElectricCar();
		System.out.println(car.drive());
	}
}
