package com.oracle.java8.professional.collection;

public class Impiegato {
	private String name;

	public Impiegato(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Impiegato impiegato = (Impiegato) o;

		return name.equals(impiegato.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
