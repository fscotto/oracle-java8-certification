package com.oracle.java8.professional.generics;

import java.util.Comparator;

public interface ComparatorWithBoundaries<T> extends Comparator<T> {
	boolean isTop(T o);
	boolean isBottom(T o);
}
