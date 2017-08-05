package com.techarha.training.ds.stack;

public class ArrayStack implements Stack<String> {

    private String[] stack;
    private int position;
    private int ARRAY_SIZE = 10 ;

    public ArrayStack(){
        this.stack = new String[this.ARRAY_SIZE];
        this.position = -1;
    }

    @Override
    public void push(String data) {
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
    public String top() {
        if(!isEmpty())
            return this.stack[position];

        throw new IndexOutOfBoundsException("Stack is empty");
    }

}
