package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer happy = null;
        for (int i = 0; i < count; i++) {
            happy = queue.poll();
        }
        return happy != null ? happy.name() : "";
    }

    public String getFirstUpsetCustomer() {
        Customer upset = null;
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
        upset = queue.poll();
        return upset != null ? upset.name() : "";
    }
}
