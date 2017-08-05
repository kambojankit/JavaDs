package com.techarha.training.ds.linked_list;

public class DoubleNode<T> extends Node<T> {
    private Node<T> previous;

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

}
