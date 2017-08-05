package com.techarha.training.ds.stack;

import com.techarha.training.ds.list.LinkedList;
import com.techarha.training.ds.list.List;

public class GenericLinkedListStack<T> implements Stack<T>{
    private List<T> list;

    public GenericLinkedListStack() {
        list = new LinkedList<T>();
    }

    @Override
    public void push(T data) {
        list.addToFront(data);
    }

    @Override
    public void pop() {
        list.removeFromFront();
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    @Override
    public T top() {
        return list.getHead().getNext().getData();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
