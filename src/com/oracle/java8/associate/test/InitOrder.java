package com.oracle.java8.associate.test;

public class InitOrder {
	public String first = "instance";
	
	public InitOrder() {
		first = "costructor";
	}
	
	{first = "block";}
	
	public void print() {
		System.out.println(first);
	}
	
	public static void main(String... args) {
		new InitOrder().print();
	}
}
