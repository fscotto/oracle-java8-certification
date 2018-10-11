package com.oracle.java8.professional.oop;

public class UrticanteComponent implements Urticante {
	private double danno;

	public UrticanteComponent(double danno) {
		this.danno = danno;
	}

	@Override
	public double getDanno() {
		return this.danno;
	}
}
