package com.oracle.associate.java8.test;

public class Automobile {
	private static int targaCorrente;
	private int targa;
	private int portiere;
	
	//1
	static {
		targaCorrente = 0;
		System.out.println("Blocco statico");
	}
	
	//2
	{
		this.targa = targaCorrente++;
		System.out.println("Blocco istanza");
	}
	
	//3
	public Automobile(int portiere) {
		this.portiere = portiere;
		System.out.println("Costruttore");
	}
	
	public static void main(String[] args) {
		new Automobile(5);
	}
}
