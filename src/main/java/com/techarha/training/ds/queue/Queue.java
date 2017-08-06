package com.techarha.training.ds.queue;

public interface Queue<T> {
    void enqueue(T data);
    void dequeue();
    T front();
    T peek();
    boolean isEmpty();
}
