package it.oracle.associate.java8.test;

abstract class House {
	protected abstract Object getSpace();
}

abstract class Room extends House {
	abstract Object getSpace(Object list);
}

abstract public class Ballroom extends House {
	@Override
	protected abstract Object getSpace();
	public static void main(String[] squareFootage) {
		System.out.println("Let's start the party"); 
	}

}
