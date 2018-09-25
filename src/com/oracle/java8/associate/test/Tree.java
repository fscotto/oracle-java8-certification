package com.oracle.java8.associate.test;

public class Tree {
	public final static long numberOfTrees;
	public final double height;
	
	static {}
	{
		final int initHeight = 2;
		height = initHeight;
	}
	
	static {
		numberOfTrees = 100;
		//height = 4;
	}
}
