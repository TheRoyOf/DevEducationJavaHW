package com;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Intention {
    private AtomicInteger sum;

    public Intention() {
        this.sum = new AtomicInteger(ThreadLocalRandom.current().nextInt(1000, 20_000 + 1));
    }

    public Intention(int origin, int bound) {
        this.sum = new AtomicInteger(ThreadLocalRandom.current().nextInt(origin, bound + 1));
    }

    public AtomicInteger getSum() {
        return sum;
    }
}
