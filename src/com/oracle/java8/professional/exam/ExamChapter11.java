package com.oracle.java8.professional.exam;

import java.util.*;

public class ExamChapter11 {

	public static void main(String[] args) {
	}

	public static void iterator() {
		List<Integer> l = Arrays.asList(1, 2, 3, 4);
		for (Iterator<Integer> i = l.iterator(); i.hasNext(); i.next())
			System.out.println(i.next());
	}

	public static <T> Set<T> intersaction(Set<? extends T> a, Set<?> b) {
		Set<T> result = new HashSet<>();
		for (T t : a) {
			if (b.contains(t))
				result.add(t);
		}
		return result;
	}
}
