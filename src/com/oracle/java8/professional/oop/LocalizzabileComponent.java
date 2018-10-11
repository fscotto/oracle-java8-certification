package com.oracle.java8.professional.oop;

public class LocalizzabileComponent implements Localizzabile {
	private double x;
	private double y;
	private double z;

	public LocalizzabileComponent(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

	@Override
	public double getZ() {
		return this.z;
	}
}
