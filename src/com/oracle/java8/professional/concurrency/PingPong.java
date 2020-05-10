package com.oracle.java8.professional.concurrency;

public class PingPong extends Thread {
    private String word;
    private int delay;

    public PingPong(String whatToSay, int delayTime) {
        this.word = whatToSay;
        this.delay = delayTime;
    }

    @Override
    public void run() {
        try {
            for (;;) {
                System.out.println(word + " ");
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new PingPong("ping", 33).start();
        new PingPong("PONG", 100).start();
    }
}
