package com.oracle.associate.java8.test;

public class Football {

	public static Long getScore(Long timeRemaining) {
		return 2 * timeRemaining; // m1
	}
	
	public static void main(String[] refs) {
		final int startTime = 4;
		//System.out.println(getScore(startTime)); // m2
	}
}
