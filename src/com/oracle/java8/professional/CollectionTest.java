package com.oracle.java8.professional;

import com.oracle.java8.professional.collection.Impiegato;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		iteratorForEach();
		usingHashSet();
		usingMap();
	}

	private static void iteratorForEach() {
		System.out.println("\niteratorForEach");
		List<String> people = Arrays.asList("Walter", "Skylar", "Jesse");
		for (String name : people) {
			System.out.println(name);
		}
	}

	private static void usingHashSet() {
		System.out.println("\nusingHashSet");
		Set<Impiegato> impiegati = new HashSet<>();
		impiegati.add(new Impiegato("Mario"));
		impiegati.add(new Impiegato("Maria"));
		impiegati.add(new Impiegato("Martina"));
		impiegati.add(new Impiegato("Valentina"));
		impiegati.add(new Impiegato("Mario"));
		for (Impiegato impiegato : impiegati) {
			System.out.println(impiegato.getName());
		}
	}

	private static void usingMap() {
		System.out.println("\nusingMap");
		Map<String, String> m = new HashMap<>();
		Set<String> s = m.keySet();
		System.out.println(s.size());
		m.put("Albuquerque", "NM");
		System.out.println(m.size());

		m = new TreeMap<>();
		m.put("Maria", "F");
		m.put("Mario", "M");
		m.put("Alberto", "M");
		System.out.println(m.size());
		System.out.println(((TreeMap<String, String>) m).firstKey());
		System.out.println(((TreeMap<String, String>) m).lastKey());
	}
}
