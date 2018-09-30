package com.oracle.java8.professional.generics;

public class Rational implements Comparable<Rational> {
	private int num, denum;

	public Rational(int num, int denum) {
		this.num = num;
		this.denum = denum;
	}

	@Override
	public int compareTo(Rational r) {
		if (num * r.denum > r.num * denum) return 1;
		if (num * r.denum < r.num * denum) return -1;
		return 0;
	}
}
