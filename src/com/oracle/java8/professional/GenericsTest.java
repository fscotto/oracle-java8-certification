package com.oracle.java8.professional;

import com.oracle.java8.professional.generics.*;

public class GenericsTest {

	public static void main(String[] args) {
		doParameterClassTest();
		doParameterMethodTest();
		doRawParameterClassTest();
		doBoundariesParameterClassTest();
		doJollyParameterTest();
		doJollyParameterBounderiesTest();
	}

	private static void doParameterClassTest() {
		Pair<Integer> p = new Pair<>(3, 5);
		Integer n = p.getFirst();

		Entry<String, Integer> e = new Entry<>("Luigi", 35);
		e.setFirst("Luigi Rossi");
		Integer n2 = e.getSecond();
	}

	private static void doParameterMethodTest() {
		String[] arr = {"uno", "due", "tre"};
		String d = GenericsTest.<String>getMedianObj(arr);
		System.out.println(d);

		//A<String> a = new <Integer>A<String>("Walter", 50);
		//a.f("Skyler");
		//a.<Boolean>g(true);

		d = GenericsTest.getMedianObj(arr);
		System.out.println(d);
	}

	private static <T> T getMedianObj(T[] a) {
		return a[a.length/2];
	}

	private static void doRawParameterClassTest() {
		Pair<Integer> pInt = new Pair<>();

		// da parametrica a grezza: warning
		Pair pGrezza = pInt;

		// da grezza a parametrica: warning
		Pair<String> pStr = new Pair<>();

		// da parametrica a parametrica (di tipo diverso):
		// errore
		//Pair<Object> pObj = pStr;
	}

	private static void doBoundariesParameterClassTest() {
		Pair<String> p = new Pair<>("max", "min");
		System.out.println(getMax(p));
	}

	private static <T extends Comparable<T>> T getMax(Pair<T> p) {
		if (p.getFirst().compareTo(p.getSecond()) <= 0) {
			return p.getFirst();
		} else {
			return p.getSecond();
		}
	}

	private static void doJollyParameterTest() {
		Pair<Object> p = new Pair<>("string", 10);
		System.out.println(areEqual(p));

		Pair<?> p1 = new Pair(); // da grezza a jolly: ok
		Pair<?> p2 = new Pair<String>(); // da parametrica a jolly: ok

		//p2.setFirst("Saul"); errore in compilazione
		p2.setSecond(null); // ok

		//String s = p2.getFirst(); errore in compilazione
		Object o = p2.getSecond(); // ok
	}

	private static boolean areEqual(Pair<?> p) {
		return p.getFirst().equals(p.getSecond());
	}

	// E' evidente che da Java 8 non è più così
	//public static <T> void f(Pair<T> p1, Pair<T> p2) {}
	//public static     void f(Pair<?> p1, Pair<?> p2) {}

	private static void doJollyParameterBounderiesTest() {
		Pair<? extends Impiegato> p1 = new Pair<Impiegato>();
		Pair<? extends  Impiegato> p2 = new Pair<Manager>();
		Pair<? super Impiegato> p3 = new Pair<Impiegato>();
		Pair<? super Impiegato> p4 = new Pair<Persona>();
		Pair<?> p5 = p1;
		Pair<?> p6 = p3;

		/*|------------------------------------------------------|
		 *| Tipo del riferimento | Tipo ass. get | parametro set |
		 *|----------------------|---------------|---------------|
		 *| A<?>                 | Object        | soltanto null |
		 *|----------------------|---------------|---------------|
		 *| A<? extends X>       | X e super-tipi| soltanto null |
		 *|----------------------|---------------|---------------|
		 *| A<? super X>         | Object        | X e sotto-tipi|
		 *|------------------------------------------------------|
		 */

		Pair<? extends Impiegato> p7 = new Pair<Manager>();
		//p7.setFirst(new Manager()); errore in compilazione
		//Manager m = p7.getFirst(); errore in compilazione
		Impiegato e1 = p7.getFirst();
		Persona e2 = p7.getFirst();
		p7.setFirst(null);

		Pair<? super Impiegato> p8 = new Pair<Object>();
		p8.setFirst(new Impiegato());
		//p8.setSecond(new Persona()); errore di compilazione
		//p8.setSecond(new Object()); errore di compilazione
		p8.setSecond(new Manager());
		//Impiegato e2 = p8.getFirst(); errore di compilazione
		Object o = p8.getFirst();
	}
}
