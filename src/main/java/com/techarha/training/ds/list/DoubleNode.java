package com.techarha.training.ds.list;

public class DoubleNode<T> extends Node<T> {
    private DoubleNode<T> previous;

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    @Override
    public DoubleNode<T> getNext() {
        return (DoubleNode<T>) super.getNext();
    }

    @Override
    public void setNext(Node<T> next) {
        super.setNext(next);
    }
}
