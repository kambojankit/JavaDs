package com.techarha.training.ds.queue;

import com.techarha.training.ds.list.Node;

import java.util.Map;

public class LinkedListQueue<T> implements Queue<T>{

    Node<T> front;
    Node<T> rear;

    public LinkedListQueue() {

    }

    @Override
    public void enqueue(T data) {
        Node<T> current = new Node<>();
        current.setData(data);
        current.setNext(null);

        if(this.front == this.rear && this.front == null) {
            this.front = current;
            this.rear = current;
        }else {
            this.rear.setNext(current);
            this.rear = current;
        }
    }

    @Override
    public void dequeue() {
        if(this.front == null){
            return;
        }
        Node<T> temp = this.front;
        if(this.front == this.rear) {
            this.front.setData(null);
            this.rear = null;
            this.front = null;
            return;
        }

        this.front = this.front.getNext();
        temp.setData(null);
        temp.setNext(null);
    }

    @Override
    public T front() {
        return this.front.getData();
    }

    @Override
    public T peek() {
        return this.front();
    }

    @Override
    public boolean isEmpty() {
        return this.rear == null;
    }

    @Override
    public String toString() {
        String strArr = "";
        Node<T> temp = this.front;

        while(temp != null){
            strArr += temp.getData() + " ";
            temp = temp.getNext();
        }
        return strArr;
    }
}
