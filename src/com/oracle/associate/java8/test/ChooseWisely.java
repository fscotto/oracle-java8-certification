package com.oracle.associate.java8.test;

public class ChooseWisely {
	public ChooseWisely() {	super(); }
	public int choose(int choise) { return 5; }
	public int choose(short choise) { return 2; }
	public int choose(long choise) { return 11; }	
	public static void main(String[] path) {
		System.out.println(new ChooseWisely().choose((byte) 2+1));
	}
}
