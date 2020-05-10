package com.oracle.java8.professional.concurrency;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver implements Runnable {
    private Data load;

    public Receiver(Data data) {
        this.load = data;
    }

    public void run() {
        for (String receivedMessage = load.receive();
             !"End".equals(receivedMessage);
             receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Logger.getAnonymousLogger().log(Level.SEVERE, "Interrupted error", e);
            }
        }
    }

}
