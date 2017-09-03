package com.techarha.training.multithreading;

import com.techarha.training.ds.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BasicPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        System.out.println("All Tasks Submitted.");


        try {
            executor.awaitTermination(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }

        System.out.println("All Tasks Completed");
    }
}

class Processor implements Runnable {

    private int id;
    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }

        System.out.println("Completed: " + id);
    }
}
