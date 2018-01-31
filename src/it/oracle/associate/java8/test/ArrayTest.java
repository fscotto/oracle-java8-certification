/*
 * Copyright (c) 2018, fscotto
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package it.oracle.associate.java8.test;

import java.util.Arrays;

/**
 *
 * @author fscotto
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] a0 = new int[10];
        System.out.println("a0 length: " + a0.length);

        int a1[] = new int[10];
        System.out.println("a1 length: " + a1.length);

        int[] a2 = new int[]{0};
        System.out.println("a2 length: " + a2.length);

        int a3[];
        a3 = new int[10];
        System.out.println("a3 length: " + a3.length);
        System.out.println(Arrays.toString(a3));
        
        MyClass[] a4 = new MyClass[]{new MyClass("classe1"), new MyClass("classe2")};
        System.out.println("a4 length: " + a4.length);
        System.out.println(Arrays.toString(a4));
        a4 = add(a4, new MyClass(("classe3")));
        System.out.println("a4 length: " + a4.length);
        System.out.println(Arrays.toString(a4));
        
        char index = 5;
        int[] a5 = new int[index];
        
        String[] a6 = {"Corey", "Ozzy", "Zakk"};
        
        f(new String[0]);
        
        //String s = a6[-1]; ArrayIndexOutOfBoundsException
        
        //Field f = new int[0].getClass().getField("length"); java.lang.NoSuchFieldException: length
        
        // non funziona
        int[] a7 = unmodifieble(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(a7));
        a7[0] = 0;
        System.out.println(Arrays.toString(a7));
        
        int[][] a8 = new int[3][3];
        
        int a[][] = {{}, {}};
    }
    
    private static int[] unmodifieble(int[] arr) {
        final int[] ret = Arrays.copyOf(arr, arr.length);
        return ret;
    }
    
    private static void f(String[] array) {
        // non fa nulla
    }

    private static MyClass[] add(MyClass[] arr, MyClass obj) {
        MyClass[] copy = arr.clone();
        System.out.println(Arrays.toString(copy));
        MyClass[] newArray = Arrays.copyOf(arr, arr.length + 10);
        System.out.println(Arrays.toString(newArray));
        for (int i = 0; i < newArray.length; i++) {
            MyClass o = newArray[i];
            if (o == null) {
                newArray[i] = obj;
                break;
            }
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

}

class MyClass {

    final String name;

    MyClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
