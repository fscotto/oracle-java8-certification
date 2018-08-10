package com.oracle.associate.java8.test;

public class RainForest extends Forest {

	public RainForest(long treeCount) {
		//this.treeCount = treeCount + 1;
		super(treeCount + 1);
	}
}

class Forest {
	public long treeCount;
	
	public Forest(long treeCount) {
		this.treeCount = treeCount + 2;
	}
}