package com.techarha.training.ds.stack;

public interface Stack<T> {
    void push(T data);
    void pop();

    boolean isEmpty();

    T top();
}
