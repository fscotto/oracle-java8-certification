package com.oracle.java8.associate;

public class Overloading {

	public static void main(String[] args) throws Exception {
		X o = new X();

		o.m(1.0, 2); // 2
		o.m(1, 2); // 4
		o.m(1, 0f); // 1
		o.m(3., 8); // 2
		o.m(0L, 9); // 3

		o.m();
		o = new Y();
		o.m();
	}
}

class X {

	public void m(int x, double y) {
		System.out.println("1");
	}

	public void m(double x, long y) {
		System.out.println("2");
	}

	public void m(float x, int y) {
		System.out.println("3");
	}

	public void m(int x, int y) {
		System.out.println("4");
	}

	public Object m() throws Exception {
		System.out.println("m() => X");
		return null;
	}
}

class Y extends X {

	@Override
	public String m() throws InstantiationException {
		System.out.println("m() => Y");
		return null;
	}
}
