package com.oracle.java8.associate.test;

public class StringTest {

	public static void main(String[] args) {
		String s = "anna";
		System.out.println(s.indexOf("g"));
		System.out.println((char) 99);
		System.out.println(s.replace('n', 'g'));
		System.out.println(s.concat("p"));

		StringBuilder sb = new StringBuilder(8);
		System.out.println(sb.capacity());
		sb.append("Ciao");
		sb.insert(4, ", Mondo");
		sb.delete(4, 5);
		sb.replace(4, 5, ", ");
		sb.ensureCapacity(8);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		System.out.println(sb.toString());
		System.out.println(s.substring(0, 4));
	}
}
