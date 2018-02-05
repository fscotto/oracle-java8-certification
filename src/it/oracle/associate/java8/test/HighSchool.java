package it.oracle.associate.java8.test;

import java.io.FileNotFoundException;
import java.io.IOException;

class School {
	public int getNumberOfStudentsPerClassroom(String... students) throws IOException {
		return 3;
	}
	
	public int getNumberOfStudentsPerClassroom() throws IOException {
		return 9;
	}
}

public class HighSchool extends School {

	@Override
	public int getNumberOfStudentsPerClassroom() throws FileNotFoundException {
		return 2;
	}
	
	public static void main(String[] args) throws IOException {
		School school = new HighSchool();
		System.out.println(school.getNumberOfStudentsPerClassroom());
	}
}
