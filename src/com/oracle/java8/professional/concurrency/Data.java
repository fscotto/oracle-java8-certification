package com.oracle.java8.professional.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {
    private String packet;
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Logger.getAnonymousLogger().log(Level.SEVERE, "Interrupted error", e);
            }
        }

        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Logger.getAnonymousLogger().log(Level.SEVERE, "Interrupted error", e);
            }
        }

        transfer = true;
        notifyAll();
        return packet;
    }

}
