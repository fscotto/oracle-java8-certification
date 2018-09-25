package com.oracle.java8.associate.test;

interface SpeakDialogue { default int talk() { return 7; } }
interface SingMonologue { default int talk() { return 5; } }

public class Performance implements SpeakDialogue, SingMonologue {
	public int talk(String... x) {
		return x.length;
	}
	
	// obbligato a fare l'override
	@Override
	public int talk() {
		// TODO Auto-generated metodoConParametroPrimitivo stub
		return SingMonologue.super.talk();
	}

	public static void main(String[] notes) {
		System.out.println(new Performance().talk(notes));
	}
}
