package com.oracle.java8.associate.test;

public class Greetings {
	String msg = null;

	public Greetings() {
	}

	public Greetings(String str) {
		msg = str;
	}

	public void displayMsg() {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Greetings g1 = new Greetings();
		Greetings g2 = new Greetings("Good Evening!");
		g1.displayMsg();
		g1.displayMsg();
	}
}
