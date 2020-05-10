package com.oracle.java8.professional;

import com.oracle.java8.professional.concurrency.BankAccount;
import com.oracle.java8.professional.concurrency.Data;
import com.oracle.java8.professional.concurrency.Receiver;
import com.oracle.java8.professional.concurrency.Sender;

public class ConcurrencyTest {

    public static void main(String[] args) {
        doBankAccoundDemo();
        doSynchronizeThreadDemo();
    }

    private static void doBankAccoundDemo() {
        BankAccount bankAccount = new BankAccount(1, 100);

        Thread worker1 = new Thread(() -> {
            System.out.printf("[Thread %s] read current balance = %d\n",
                    Thread.currentThread().getName(), bankAccount.getBalance());
            bankAccount.deposit(10);
        });

        Thread worker2 = new Thread(() -> {
            System.out.printf("[Thread %s] read current balance = %d\n",
                    Thread.currentThread().getName(), bankAccount.getBalance());
            bankAccount.deposit(10000);
        });

        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
            System.out.println("Final balance is " + bankAccount.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doSynchronizeThreadDemo() {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }

}
