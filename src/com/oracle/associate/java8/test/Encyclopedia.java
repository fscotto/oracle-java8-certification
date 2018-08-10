package com.oracle.associate.java8.test;

abstract class Book {
	protected static String material = "papyrus";
	public Book() {}
	public Book(String material) { this.material = material; }
}

public class Encyclopedia extends Book {
	public static String material = "cellulose";
	public Encyclopedia() {super();}
	public String getMaterial() { return super.material; }
	public static void main(String[] pages) {
		System.out.println(new Encyclopedia().getMaterial());
	}
}
