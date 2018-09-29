package com.oracle.java8.associate;

public class Eridarieta {

	public static void main(String[] args) {
		Animale[] animali = {
				creaAnimale("Cane"),
				creaAnimale("Coccodrillo"),
				creaAnimale("Coccodrillo"),
				creaAnimale("Cane")
		};

		for (Animale a : animali) {
			if (a instanceof Animale) {
				System.out.println(a.getClass().getSimpleName() + " sono un animale");
			}
			if (a instanceof Mammifero) {
				System.out.println(a.getClass().getSimpleName() + " sono un mammifero");
			}
			if (a instanceof Rettile) {
				System.out.println(a.getClass().getSimpleName() + " sono un rettile");
			}

			a.muove();
		}
	}

	static Animale creaAnimale(String tipo) {
		switch (tipo) {
			case "Cane":
				return new Cane();
			case "Coccodrillo":
				return new Coccodrillo();
			default:
				throw new RuntimeException("Tipo animale non esistente");
		}
	}
}

interface Animale {
	void muove();
}

abstract class Mammifero implements Animale {
	protected int gambe;

	public int getGambe() {
		return gambe;
	}

	public void setGambe(int gambe) {
		this.gambe = gambe;
	}
}

abstract class Rettile implements Animale {
	protected int temperatura;

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
}

class Cane extends Mammifero {

	public Cane() {
		super();
		this.gambe = 4;
	}

	@Override
	public void muove() {
		System.out.println(String.format("Corre sulle %d gambe", getGambe()));
	}
}

class Coccodrillo extends Rettile {

	public Coccodrillo() {
		super();
		this.temperatura = 30;
	}

	@Override
	public void muove() {
		System.out.println(String.format("Ha una temperatura di %d°C", temperatura));
	}
}