package com.oracle.java8.associate.test;

public class Calculations {

	private enum CardinalPoint {
		NORTH, SOUTH, WEST, EST
	}

	public Boolean findAverage(boolean sum) {
		return sum;
	}

	public Byte findAverage(byte sum) {
		return sum;
	}
	
	public Character findAverage(char sum) {
		return sum;
	}
	
	public Short findAverage(short sum) {
		return sum;
	}
	
	public Integer findAverage(int sum) {
		return sum;
	}
	
	public Long findAverage(long sum) {
		return sum;
	}
		
	public Float findAverage(float sum) {
		return sum;
	}
	
	public Double findAverage(double sum) {
		return sum;
	}

	public static void main(String[] args) {
		Calculations c = new Calculations();
		System.out.println(c.findAverage((char) 36));
		
		char ch = 0b0010_0100;
		System.out.println(ch);
		
		ch = 0x24;
		System.out.println(ch);
		
		byte b = 100;
		switch (b) {
		case 100:
			break;
		case 20:
			break;
		}
	}
	
}

