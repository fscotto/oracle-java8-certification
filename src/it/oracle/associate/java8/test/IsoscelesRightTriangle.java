package it.oracle.associate.java8.test;

abstract class Triangle {
	abstract String getDescription();
}

class RightTriangle extends Triangle {
	@Override
	protected String getDescription() { return "rt"; } // g1
}

public abstract class IsoscelesRightTriangle extends RightTriangle { // g2
	@Override
	public String getDescription() {
		return "irt";
	}
	
	public static void main(String[] args) {
		//final Triangle shape = new IsoscelesRightTriangle(); // g3
	}
}
