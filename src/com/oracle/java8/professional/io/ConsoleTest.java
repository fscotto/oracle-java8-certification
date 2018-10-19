package com.oracle.java8.professional.io;

import java.io.Console;

public class ConsoleTest {

    public static void main(String[] args) {
        String linea = "";

        // Reperisco l'istanza di Console
        // Attenzione: si tratta di un singleton!
        // Dunque non può essere istanziato con il new
        Console cons = System.console();

        System.out.println("Console is null: " + (cons == null));

        // Istanzio un array di caratteri
        // e ci metto la password digitata
        // che non verrà mostrata a video
        char[] passw;
        passw = cons.readPassword("%s", "password: ");

        // scorro l'array e stampo la password
        for (char c : passw) {
            cons.format("%c ", c);
        }
        cons.format("\n");

        // lancio il metodo della classe da testare
        TestClass tc = new TestClass();
        while (true) {
            linea = cons.readLine("%s", "digita: ");
            cons.format("output: %s \n", tc.fai(linea));
        }
    }
}

class TestClass {

    String fai(String s) {
        return "Linea: " + s;
    }
}