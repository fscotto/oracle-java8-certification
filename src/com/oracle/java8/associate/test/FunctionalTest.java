package com.oracle.java8.associate.test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalTest {

	public static void main (String[] args) {
		Consumer<String> c1 = s -> s.toLowerCase();
		Consumer<String> c2 = s -> s.trim();
		String var = " Hello WORLD!!!";
		c1.andThen(c2).accept(var);
		System.out.println(var);

		EmployeeFactory factory = Employee::new;
		Employee employee = factory.getEmployee("John Hammond", 25);
		System.out.println(employee);

		Function<Object, String> convert = FunctionalTest::convert;
		String ciao = convert.apply("Ciao");
		System.out.println(ciao);
	}

	private static String convert(Object o) {
		Function<Object, String> f = obj -> obj.toString();
		return f.apply(o);
	}
}

class Employee {
	String name;
	Integer age;

	public Employee (String name) {
		this.name = name;
	}

	public Employee (String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString () {
		return "Employee{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}

@FunctionalInterface
interface EmployeeFactory {
	Employee getEmployee(String name, Integer age);
}
