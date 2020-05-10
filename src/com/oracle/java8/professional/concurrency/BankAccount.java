package com.oracle.java8.professional.concurrency;

public class BankAccount {
    private long number;
    private long balance;

    public BankAccount(long number, long balance) {
        this.number = number;
        this.balance = balance;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amout) {
        balance += amout;
    }
}
