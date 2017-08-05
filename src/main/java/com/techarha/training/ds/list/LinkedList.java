package com.techarha.training.ds.list;

import com.techarha.training.ds.exceptions.IndexOutOfBoundException;

public class LinkedList<T> implements List<T>{
    Node<T> head = new Node<>();


    public LinkedList(){
        head = new Node<T>();
        head.setNext(null);
        head.setData(null);
    }

    @Override
    public Node<T> getHead(){
        return this.head;
    }

    /**
     * The operation has a complexity of O(1)
     * @param data
     */
    @Override
    public void addToFront(T data){
        Node<T> temp = new Node<>();

        temp.setData(data);
        temp.setNext(head.getNext());

        head.setNext(temp);
    }


    /**
     * Removes one Node from front of the linked list
     * The operation has a complexity of O(1)
     */
    @Override
    public void removeFromFront(){
        if(getSize() < 1) {
            throw new IndexOutOfBoundException("Cannot remove Node from Empty List");
        }
        Node<T> temp = this.head.getNext();

        this.head.setNext(temp.getNext());
        temp.setData(null);
        temp.setNext(null);
    }

    /**
     * The operation has a complexity of O(n), where n is number of elements in the list
     * @param data
     */
    @Override
    public void addToEnd(T data){
        Node<T> dataNode = new Node<>();

        dataNode.setData(data);
        dataNode.setNext(null);

        Node<T> tempHead = this.head;
        while(tempHead.getNext() != null) {
            tempHead = tempHead.getNext();
        }

        tempHead.setNext(dataNode);
    }

    /**
     * Removed a Node from End of the list
     * The operation has a complexity of O(n)
     */
    @Override
    public void removeFromEnd(){
        Node<T> current = this.head;

        Node<T> previous = null;
        while(current.getNext() != null){
            previous = current;
            current = current.getNext();
        }

        //remove current and make previous as last node
        current.setData(null);
        current.setNext(null);

        previous.setNext(null);
    }

    /**
     * Insert the data at position 'index' in the list.
     * Note that index should not be greater than size of the list.
     * The operation has a complexity of O(n), if node is inserted at position other than 0.
     * @param data
     * @param index
     */
    @Override
    public void insertAt(T data, int index) {
        if(index > -1 && index <= getSize()) {

            if(index == 0){
                this.addToFront(data);
                return;
            }
            if(index == getSize() + 1) {
                this.addToEnd(data);
                return;
            }

            Node<T> dataNode = new Node<T>();
            dataNode.setData(data);

            int position= 0;
            Node<T> tempData = this.head;
            while(tempData.getNext() != null){
                tempData = tempData.getNext();
                if(position == index - 1 ) {
                    //Pointing newly added node, to the one pointed to by element at position = index-1
                    dataNode.setNext(tempData.getNext());

                    tempData.setNext(dataNode);
                    break;
                }
                position++;
            }
        }else {
            throw new IndexOutOfBoundException("Cannot add Node at provided location");
        }
    }

    /**
     * Removes Node at provided position
     * The complexity of the operation is O(n)
     * @param index
     */
    @Override
    public void removeAt(int index) {
        if(index > -1 && index < getSize()) {
            if(index == 0) {
                this.removeFromFront();
                return;
            }
            if(index == getSize() - 1) {
                this.removeFromEnd();
                return;
            }
            Node<T> current = this.head;

            int position = 0;
            Node<T> previous = null;
            while(current.getNext() != null){
                previous = current;
                current = current.getNext();
                if(position == index) {
                    break;
                }
                position++;
            }

            //remove current and make previous Node point to the node current Node links to.
            previous.setNext(current.getNext());

            current.setData(null);
            current.setNext(null);

        }else {
            throw new IndexOutOfBoundException("Cannot delete Node at the provided location");
        }
    }

    @Override
    public void reverseList() {
        if(getSize() < 1) {
            throw new IndexOutOfBoundException("Cannot reverse an empty list");
        }

        Node<T> current = this.head.getNext();
        Node<T> previous = null;

        while(current != null) {
//            current = current.getNext();
            Node<T> next = current.getNext();
            current.setNext(previous);
            previous = current;

            current = next;
        }

        this.head.setNext(previous);
    }

    @Override
    public void reverseListRecursive(Node node) {
        if(node.getNext() == null) {
            this.head = new Node<>();
            this.head.setNext(node);
            return;
        }else {
            reverseListRecursive(node.getNext());
            Node<T> next = node.getNext();
            if(node.getData() == null){
                next.setNext(null);
            }else {
                node.setNext(null);
                next.setNext(node);
            }
        }
    }

    /**
     * The size is the number of elements present in the Linked List
     * @return
     */
    @Override
    public Integer getSize() {
        Integer size = 0;
        Node<T> tempNode = this.head;
        while(tempNode.getNext() != null){
            tempNode = tempNode.getNext();
            size++;
        }
        return size;
    }

    @Override
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
