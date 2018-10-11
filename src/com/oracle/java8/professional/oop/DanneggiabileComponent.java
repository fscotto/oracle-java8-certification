package com.oracle.java8.professional.oop;

public class DanneggiabileComponent implements Danneggiabile {
	private double vita;

	public DanneggiabileComponent(double vita) {
		this.vita = vita;
	}

	@Override
	public void riceviColpo(double intensita) {
		this.vita -= intensita;
	}

	@Override
	public boolean isDistrutto() {
		return this.vita <= 0;
	}
}
