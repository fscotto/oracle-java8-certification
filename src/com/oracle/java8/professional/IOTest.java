package com.oracle.java8.professional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOTest {

	public static void main(String[] args) throws Exception {
		doUsingFileTest();
		doModifyFileContentTest();
		doWrappingFileWriterTest();
		doFileOperationTest();
		doListingFileInDirectory();
	}

	private static void doUsingFileTest() throws IOException {
		boolean esiste = false;
		File file = new File("ilMioPrimoFile.txt");
		System.out.println(file.exists());
		esiste = file.createNewFile();
		System.out.println(esiste);
		System.out.println(file.exists());
		file.delete();

		File file2 = new File("mioFile2.txt");
		file2.createNewFile();
		file2.delete();

		File file3 = new File("mioFile3.txt");
		PrintWriter pw = new PrintWriter(file3);
		file3.delete();

		File dir1 = new File("laMiaDirectory");
		dir1.mkdir();

		File file4 = new File(dir1, "mioFile.txt");
		file4.createNewFile();
		file4.delete();
		dir1.delete();
	}

	private static void doModifyFileContentTest() throws IOException {
		char[] in = new char[50];
		int size = 0;
		File file = new File("fileWrite2.txt");
		FileWriter fw = new FileWriter(file);
		fw.write("lunedì\nmartedì\n");
		fw.flush();
		fw.close();
		FileReader fr = new FileReader(file);
		size = fr.read(in);
		System.out.println(size + " ");
		for (char c : in)
			System.out.print(c);
		fr.close();
	}

	private static void doWrappingFileWriterTest() throws IOException {
		File file = new File("fileWrite2.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		System.out.println(br.readLine());
		file.delete();
	}

	private static void doFileOperationTest() throws IOException {
		// creazione di una directory
		File miaDir = new File("miaDir");
		miaDir.mkdir();

		// creazione di un primo file nella directory
		File file1 = new File(miaDir, "file1.txt");
		file1.createNewFile();

		// creazione di un secondo file nella directory
		File file2 = new File(miaDir, "file2.txt");
		file2.createNewFile();

		// cancellazione del primo file
		file1.delete(); // delete a file

		// tentativo di cancellazione della directory
		System.out.println("miaDir eliminata? " + miaDir.delete());

		// creazione di un nuovo file
		File file3 = new File(miaDir, "file3.txt");

		// rinomina del secondo file
		file2.renameTo(file3);

		// rinomina della directory
		File newDir = new File("miaDir2");
		miaDir.renameTo(newDir);

		file2.delete();
		miaDir.delete();
	}

	private static void doListingFileInDirectory() {
		// Si ipotizzi che la directory contenga max 100 elementi
		String[] elementi = new String[100];

		// si crea il riferimento alla directory
		File miaDir = new File("miaDir");

		// list restituisce un array di stringhe, contenente
		// i nomi degli elementi all'interno della directory
		elementi = miaDir.list();

		// scorro l'array
		for (String nome : elementi) {
			System.out.println("Elemento trovato: " + nome);
		}
	}
}
