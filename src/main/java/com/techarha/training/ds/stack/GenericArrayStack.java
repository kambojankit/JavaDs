package com.techarha.training.ds.stack;

import java.lang.reflect.Array;

public class GenericArrayStack<T> implements Stack<T> {

    private T[] stack;
    Class<T> providedClassType;
    private int position;
    private int ARRAY_SIZE = 2 ;
    private int resizeFactor = 2;

    public GenericArrayStack(Class<T> clazz){
        this.providedClassType = clazz;
        this.stack = (T[]) Array.newInstance(clazz, ARRAY_SIZE);
        this.position = -1;
    }

    @Override
    public void push(T data) {
        if(this.position == ARRAY_SIZE -1) {
            this.resizeStack();
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

    private void resizeStack() {
        System.out.print("resizing stack..");
        this.ARRAY_SIZE = this.ARRAY_SIZE * this.resizeFactor;

        T[] updatedStack = (T[]) Array.newInstance(this.providedClassType, this.ARRAY_SIZE);

        this.copyOver(updatedStack);
    }

    private void copyOver(T[] newStack) {
        for(int i=0; i <= position; i++) {
            newStack[i] = this.stack[i];
        }

        this.stack = newStack;
    }
}
