package com.oracle.associate.java8.test;

import java.io.EOFException;

class Machine {
	public boolean turnOn() throws EOFException { return true; }
}

public class Robot extends Machine {
	@Override
	public boolean turnOn() { return false; }
	public static void main(String[] doesNotCompute) throws Exception {
		Machine m = new Robot();
		System.out.println(m.turnOn());
	}
}
