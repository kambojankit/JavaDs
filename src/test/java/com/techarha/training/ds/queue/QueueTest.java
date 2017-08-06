package com.techarha.training.ds.queue;

public class QueueTest {

    public static void basicArrayTest() {
        Queue<String> strQueue = new ArrayQueue<>(String.class);

        strQueue.enqueue("A");
        System.out.println("En Queue State: " + strQueue);

        strQueue.enqueue("B");
        strQueue.enqueue("C");
        System.out.println("En Queue State: " + strQueue);

        strQueue.enqueue("D");
        strQueue.enqueue("E");
        strQueue.enqueue("F");
        System.out.println("En Queue State: " + strQueue);

        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);


        strQueue.enqueue("H");
        strQueue.enqueue("I");
        System.out.println("En Queue State: " + strQueue);
    }
}
