package com.techarha.training.ds.stack;

import java.lang.reflect.Array;

public class GenericArrayStack<T> implements Stack<T> {

    private T[] stack;
    private int position;
    private int ARRAY_SIZE = 10 ;

    public GenericArrayStack(Class<T> clazz){
        this.stack = (T[]) Array.newInstance(clazz, ARRAY_SIZE);
        this.position = -1;
    }

    @Override
    public void push(T data) {
        if(this.position == ARRAY_SIZE -1) {
            throw new IndexOutOfBoundsException("Stack is full");
        }

        this.stack[++position] = data;
    }

    @Override
    public void pop() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        position--;
    }

    @Override
    public boolean isEmpty() {
        return position < 0;
    }

    @Override
    public T top() {
        if(!isEmpty())
            return this.stack[position];

        throw new IndexOutOfBoundsException("Stack is empty");
    }


    @Override
    public String toString() {
        String arrStr = "";

        for(T str: this.stack){
            arrStr += str != null? str + " " : "";
        }
        return arrStr;
    }
}
