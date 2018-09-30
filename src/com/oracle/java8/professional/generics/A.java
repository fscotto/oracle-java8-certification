package com.oracle.java8.professional.generics;

public class A<S, T extends Impiegato & Comparable<String>, U extends S> {

	public <T> A(S s, T t) {}

	public void f(S s) {}

	public <T> void g(T t) {}
}
