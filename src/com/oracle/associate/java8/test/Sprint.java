package com.oracle.associate.java8.test;

interface Run {
	default void walk() {
		System.out.println("Walking and running!");
	}
}

interface Jog {
	default void walk() {
		System.out.println("Walking and jogging!");
	}
}

public class Sprint implements Run, Jog {
	@Override
	public void walk() {
		System.out.println("Sprinting!");
	}
	
	public static void main(String[] args) {
		new Sprint().walk();
	}
}
