package com.oracle.java8.associate.test;

interface MusicCreator { public Number play(); }
abstract class StringInstrument { public Long play() { return 3L; } }
public class Violin extends StringInstrument implements MusicCreator {
	@Override
	public Long play() {
		return null;
	}
}
