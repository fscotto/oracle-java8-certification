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
package it.oracle.associate.java8;

import it.oracle.associate.java8.test.B;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fscotto
 */
public class Exam1 {

    public static void main(String[] args) {
        Exam1 e = new Exam1();
        e.question27();
    }

    private void question1() {
        new B().print();
    }

    private void question2() {
        LocalDateTime obj = LocalDateTime.now();
        System.out.println(obj.getSecond());
    }

    private void question3() {
        ArrayList<Counter> original = new ArrayList<>();
        original.add(new Counter((10)));

        ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone();
        cloned.get(0).counter = 5;

        System.out.println(original);
    }

    private void question4() {
        List<String> l1 = new ArrayList<>();
        l1.add("A");
        l1.add("D");

        List<String> l2 = new ArrayList<>();
        l2.add("B");
        l2.add("C");

        l1.addAll(1, l2);

        System.out.println(l1);
    }

    public void question5() {
        do {
            System.out.println(100);
        } while (false);
        System.out.println("Bye");
    }

    public void question10() {
        List<Integer> l = new ArrayList<>();
        l.add(new Integer(2));
        l.add(new Integer(1));
        l.add(new Integer(0));

        l.remove(l.indexOf(0));
        System.out.println(l);
    }

    public void question11() {
        int a = 100;
        System.out.println(-a++);
    }

    public void question14() {
        LocalDate date = LocalDate.of(2012, 1, 11);
        Period period = Period.ofMonths(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
        System.out.print(formatter.format(date.minus(period)));
    }

    public void question15() {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2018-07-11"));
        dates.add(LocalDate.parse("1919-02-25"));
        dates.add(LocalDate.of(2020, 4, 8));
        dates.add(LocalDate.of(1980, Month.DECEMBER, 31));

        dates.removeIf(x -> x.getYear() < 2000);

        System.out.println(dates);
    }

    public void question16() {
        Point p1 = new Point();
        p1.x = 10;
        p1.y = 20;
        Point p2 = new Point();
        p2.assign(p1.x, p1.y);
        System.out.println(p1.toString() + ";" + p2.toString());
    }

    public void question17() {
        String str = "java";
        StringBuilder sb = new StringBuilder("java");

        System.out.println(str.equals(sb) + ":" + sb.equals(str));
    }

    public void question18() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("James", 25));
        students.add(new Student("James", 27));
        students.add(new Student("James", 25));
        students.add(new Student("James", 25));

        students.remove(new Student("James", 25));

        for (Student stud : students) {
            System.out.println(stud);
        }
    }

    public void question19() {
        String swiftCode = "ICICINBBRT4";
        System.out.println(swiftCode.substring(4, 6));
    }

    public void question22() {
        LocalDate date = LocalDate.of(2020, 9, 31);
        System.out.println(date);
    }

    public void question23() {
        StringBuilder sb = new StringBuilder("Java");
        String s1 = sb.toString();
        String s2 = sb.toString();

        System.out.println(s1 == s2);
    }

    private void question26() {
        String fruit = "mango";
        switch (fruit) {
            default:
                System.out.println("ANY FRUIT WILL DO");
            case "Apple":
                System.out.println("APPLE");
            case "Mango":
                System.out.println("MANGO");
            case "Banana":
                System.out.println("BANANA");
                break;
        }
    }

    private void m(int x) {
        System.out.println("int version");
    }

    private void m(char x) {
        System.out.println("char version");
    }

    private void question27() {
        int i = '5';
        m(i);
        m('5');
    }

    private void question28() {
        LocalDate date = LocalDate.parse("1947-08-14");
        LocalTime time = LocalTime.MAX;
        System.out.println(date.atTime(time));
    }

    private void question33() {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(100);
        list.add(200);

        list.remove(100);

        System.out.println(list);
    }

    public void question35() {
//        Super s = new Sub();
//        try {
//            s.m1();
//        } catch (FileNotFoundException e) {
//            System.out.print("M");
//        } finally {
//            System.out.print("N");
//        }
    }

    private void question39() {
        String str1 = new String("Core");
        String str2 = new String("CoRe");
        System.out.println(str1 = str2);
    }

    private void question42() {
        List<Character> list = new ArrayList<>();
        list.add(0, 'V');
        list.add('T');
        list.add(1, 'E');
        list.add(3, 'O');

        if (list.contains('O')) {
            list.remove('O');
        }

        for (char ch : list) {
            System.out.print(ch);
        }
    }

    private void question43() {
        System.out.println(new String("Java"));
        System.out.println(new StringBuilder("Java"));
        System.out.println(new SpecialString("Java"));
    }

    private void question45() {
//        double price = 90000;
//        String model;
//        if (price > 100000) {
//            model = "Tesla Model X";
//        } else if (price <= 100000) {
//            model = "Tesla Model S";
//        }
//        System.out.println(model);
    }

    private void question47() {
        char var = 7;
        switch (var) {
            case 7:
                System.out.println("Lucky no. 7");
                break;
            default:
                System.out.println("DEFAULT");
        }
    }

    private void question48() {
        String s = new String("Hello");
        List<String> list = new ArrayList<>();
        list.add(s);
        list.add(new String("Hello"));
        list.add(s);
        s.replace("l", "L");

        System.out.println(list);
    }

    private void question50() {
        short[] arr;
        arr = new short[2];
        arr[0] = 5;
        arr[1] = 10;
        System.out.println("[" + arr[0] + ", " + arr[1] + "]");
    }

    private void question52() {
//        double [] arr = new int[2]; //Line 3
    }

    private void question53() {
        LocalDate newYear = LocalDate.of(2018, 1, 1);
        LocalDate christmas = LocalDate.of(2018, 12, 25);
        boolean flag1 = newYear.isAfter(christmas);
        boolean flag2 = newYear.isBefore(christmas);
        System.out.println(flag1 + ":" + flag2);
    }

    private void question54() {
        //m1();
    }

    private static void m1() throws Exception { //Line 6
        System.out.println("NOT THROWING ANY EXCEPTION"); //Line 7
    }

    private void question55() {
        A obj1 = new A();
        B obj2 = (B) obj1;
        //obj2.print();
    }

    private void question57() {
        Period period = Period.of(0, 0, 0);
        System.out.println(period);
    }

    private void question59() {
        Double[] arr = new Double[2];
        System.out.println(arr[0] + arr[1]);
    }

    private void question61() {
//        byte var = 100;
//        switch (var) {
//            case 100:
//                System.out.println("var is 100");
//                break;
//            case 200:
//                System.out.println("var is 200");
//                break;
//            default:
//                System.out.println("In default");
//        }
    }
}

class SpecialString {

    String str;

    SpecialString(String str) {
        this.str = str;
    }
}

abstract class Super {

    public abstract void m1() throws IOException;
}

class Sub extends Super {

    @Override
    public void m1() throws IOException {
        throw new FileNotFoundException();
    }
}
