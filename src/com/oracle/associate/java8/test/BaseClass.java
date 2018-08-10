package com.oracle.associate.java8.test;

public abstract class BaseClass {
	
	private String name;
	
	public BaseClass(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
