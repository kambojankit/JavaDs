package com.techarha.training.ds.queue;

public class QueueTest {

    public static void basicArrayQueueTest() {
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

    public static void basicLinkedListQueueTest() {
        Queue<String> strQueue = new LinkedListQueue<String>();

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

    public static void basicCircularArrayQueueTest() {
        Queue<String> strQueue = new ArrayCircularQueue<>(String.class);

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
        System.out.println("De Queue State: " + strQueue);
        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);
        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);
        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);
        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);
        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);
        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);
        strQueue.dequeue();
        System.out.println("De Queue State: " + strQueue);
        strQueue.enqueue("A");
        System.out.println("En Queue State: " + strQueue);
    }
}
