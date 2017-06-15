package com.test.api;

/**
 * Created by sujitagarwal on 05/04/17.
 */
public class MyRunnable1 implements Runnable {
    private final long countUntil;

    MyRunnable1(long countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public void run() {
        throw new RuntimeException("exception from runnable");
    }
}