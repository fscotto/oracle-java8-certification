package com.oracle.java8.associate.test;

public class WrapperTest {

	public static void main(String[] args) {
		Integer i = null;
		//metodoConParametroPrimitivo(i); /* Questa istruzione genere NullPointerException */
		i = new Integer(10);

		System.out.println(i == 1);
		System.out.println(i.equals((int) 10L));
		System.out.println(i == 10L);

		Byte b = new Byte(i.byteValue());
		System.out.println(b.equals((byte) 10));
	}

	static void metodoConParametroPrimitivo(int i) {
		System.out.println(i);
	}
}
