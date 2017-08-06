package com.techarha.training.ds.queue;

import java.lang.reflect.Array;

public class ArrayQueue<T> implements Queue<T> {

    T[] container;
    int containerSize = 10;
    int front = -1;
    int rear = -1;

    public ArrayQueue(Class<T> clazz) {
        this.container = (T[]) Array.newInstance(clazz, this.containerSize);
    }

    @Override
    public void enqueue(T data) {
        if(rear == front && rear == -1){
            front++;
        }
        if(rear == containerSize -1) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        this.container[++rear] = data;
    }

    @Override
    public void dequeue() {
        if(front < 0 ) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        if(front == rear) {
            front = -1;
            rear = -1;
        }else {
            container[front++] = null ;
        }
    }

    @Override
    public T front() {
        return this.container[front];
    }

    @Override
    public T peek() {
        return this.front();
    }

    @Override
    public boolean isEmpty() {
        return this.front == -1;
    }

    @Override
    public String toString() {
        String strArr = "";
        for(int i =front; i <= rear; i++ ){
            strArr += container[i] == null ? "" : container[i] + " ";
        }
        return strArr;
    }
}
