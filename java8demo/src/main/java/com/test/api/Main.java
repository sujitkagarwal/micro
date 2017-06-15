package com.test.api;

/**
 * Created by sujitagarwal on 05/04/17.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NTHREDS = 5;

    public static void main(String[] args)throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable("" + i);
            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        executor.awaitTermination(10000,TimeUnit.MILLISECONDS);
        while (!executor.isTerminated()) {
            System.out.println("waiting.....");
        }
        System.out.println("Finished all threads");
    }

}