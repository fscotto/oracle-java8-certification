package it.oracle.associate.java8.test;

import java.io.FileNotFoundException;

class Math {
	public final double secret = 2;
}

class ComplexMath extends Math {
	public final double secret = 4;
	
	protected void dance() throws FileNotFoundException {
		return;
	}
}

public class InfiniteMath extends ComplexMath {
	public final double secret = 8;
	public static void main(String[] args) {
		Math math = new InfiniteMath();
		System.out.println(math.secret);
	}
	
	@Override
	public final void dance() {
		return;
	}
}
