package com.oracle.java8.professional.concurrency;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Logger.getAnonymousLogger().log(Level.SEVERE, "Interrupted error", e);
            }
        }
    }

}
