package com.techarha.training.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandlingThreads {

    private static class Printer implements Runnable{
        private String name = "Hello";
        private boolean isValid = true;

        @Override
        public void run() {
            while(isValid) {
                System.out.println(name + ": " + isValid);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printThreadA = new Thread(printer);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printThreadA.start();

        try {
            System.out.println("Press Enter to stop");
            String data = reader.readLine();

            if(data != null) {
                printer.isValid = false;
                System.out.println("=====================================" + printer.isValid);
            }

            printThreadA.join();

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Printing Complete");
    }
}
