package com.techarha.training.multithreading;

public class HandlingThreads_1 {
    public static int count = 0;

    public synchronized void increment() {
        count++;
    }
    public static void main(String[] args) {
        HandlingThreads_1 handlingThreads = new HandlingThreads_1();
        handlingThreads.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i ++){
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i ++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        System.out.println("I am Done, count is: "+ count);
    }
}
