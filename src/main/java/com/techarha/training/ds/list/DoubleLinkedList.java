package com.techarha.training.ds.list;

public class DoubleLinkedList<T> implements List<T> {
    DoubleNode<T> head;

    public DoubleLinkedList(){
        this.head = new DoubleNode<>();
    }

    @Override
    public Node<T> getHead() {
        return this.head;
    }

    @Override
    public void addToFront(T data) {
        DoubleNode<T> currentNode = new DoubleNode<>();
        currentNode.setData(data);

        DoubleNode<T> nextNode = this.head.getNext();
        if(nextNode != null) {
            nextNode.setPrevious(currentNode);
        }

        currentNode.setNext(nextNode);
        currentNode.setPrevious(this.head);
        this.head.setNext(currentNode);
    }

    @Override
    public void removeFromFront() {
        DoubleNode<T> currentNode = this.head.getNext();

        DoubleNode<T> nextNode = currentNode.getNext();

        this.head.setNext(nextNode);
        nextNode.setPrevious(this.head);

        currentNode.setPrevious(null);
        currentNode.setNext(null);
        currentNode.setData(null);
    }

    @Override
    public void addToEnd(T data) {
        DoubleNode<T> currentNode = this.head;

        DoubleNode<T> dataNode = new DoubleNode<>();
        dataNode.setData(data);
        dataNode.setNext(null);

        while(currentNode.getNext() != null ) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(dataNode);
        dataNode.setPrevious(currentNode);
    }

    @Override
    public void removeFromEnd() {
        DoubleNode<T> currentNode = this.head;

        while(currentNode.getNext() != null ) {
            currentNode = currentNode.getNext();
        }

        DoubleNode<T> lastNode = currentNode.getPrevious();
        currentNode.setPrevious(null);
        currentNode.setData(null);

        lastNode.setNext(null);
    }

    @Override
    public void insertAt(T data, int index) {
        //TODO implement insertAt
    }

    @Override
    public void removeAt(int index) {
        //TODO implement removeAt
    }

    @Override
    public void reverseList() {
        //TODO implement reversing a list using iteration
    }

    @Override
    public void reverseListRecursive(Node node) {
        //TODO implement reversing a list using Recursion
    }

    @Override
    public Integer getSize() {
        return 0;
    }

    public String toString() {
        String listStr = "";
        Node<T> tempNode = this.head;
        while(tempNode.getNext() != null){
            tempNode = tempNode.getNext();
            listStr += tempNode.getData() + " ";
        }
        return listStr;
    }
}
