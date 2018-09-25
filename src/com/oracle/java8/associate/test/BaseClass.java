package com.oracle.java8.associate.test;

public abstract class BaseClass {
	
	private String name;
	
	public BaseClass(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
