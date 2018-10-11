package com.oracle.java8.professional.oop;

public class Mina implements Localizzabile, Danneggiabile, Urticante {
	private static final double DANNO = 20;
	private static final double VITA = 50;

	private final Danneggiabile dh;
	private final Urticante uh;
	private final Localizzabile lh;

	public Mina(double x, double y, double z) {
		this.dh = new DanneggiabileComponent(VITA);
		this.uh = new UrticanteComponent(DANNO);
		this.lh = new LocalizzabileComponent(x, y, z);
	}

	@Override
	public void riceviColpo(double intensita) {
		dh.riceviColpo(intensita);
	}

	@Override
	public boolean isDistrutto() {
		return dh.isDistrutto();
	}

	@Override
	public double getX() {
		return lh.getX();
	}

	@Override
	public double getY() {
		return lh.getY();
	}

	@Override
	public double getZ() {
		return lh.getZ();
	}

	@Override
	public double getDanno() {
		return uh.getDanno();
	}
}
