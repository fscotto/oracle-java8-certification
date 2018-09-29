package com.oracle.java8.associate;

import java.util.ArrayList;
import java.util.List;

public class Auto {
	private static int conteggio;
	private String marca;

	static {
		System.out.println("Blocco statico");
	}

	{
		System.out.println("Blocco di inizializzazione");
	}

	public Auto() {
		System.out.println("Costruttore");
		this.marca = "";
		conteggio++;
	}

	public Auto(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public static int getConteggio() {
		return conteggio;
	}

	@Override
	protected void finalize() throws Throwable {
		--conteggio;
		super.finalize();
	}

	public static void main(String[] args) {
		List<Auto> autos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Auto a1 = new Auto();
			autos.add(a1);
			System.out.println(Auto.getConteggio());
		}
		autos.clear();
		wait(0.1);
		System.out.println(Auto.getConteggio());
	}

	private static void wait(double second) {
		try {
			System.gc();
			Thread.sleep((long) (second * 1000));
		} catch (Exception e) {}
	}
}
