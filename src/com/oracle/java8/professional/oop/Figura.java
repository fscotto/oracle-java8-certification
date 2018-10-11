package com.oracle.java8.professional.oop;

public abstract class Figura {
	private double x, y;

	public abstract void disegna();

	public void sposta(double deltaX, double deltaY) {
		x += deltaX;
		y += deltaY;
		disegna();
	}
}
