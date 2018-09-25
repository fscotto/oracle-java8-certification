package com.oracle.java8.associate.test;

public class DefaultInterface {

	public static void main (String[] args) {
		Delta delta = new Delta();
		delta.print();

		Alpha.staticMethod();
	}
}

class Delta implements Alpha, Beta {

	@Override
	public void print() {
		Alpha.super.print();
	}
}

interface Alpha {

	default void print() {
		System.out.println("print ALPHA");
	}

	static void staticMethod() {
		System.out.println("static metodoConParametroPrimitivo");
	}
}

interface Beta {

	default void print() {
		System.out.println("print BETA");
	}
}

interface Gamma extends Alpha {

	default void print() {
		System.out.println("print GAMMA");
	}
}
