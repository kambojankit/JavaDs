package com.techarha.training.ds.linked_list;

import com.techarha.training.ds.exceptions.IndexOutOfBoundException;

public class LinkedList<T> implements List<T>{
    Node<T> head = new Node<>();


    public LinkedList(){
        head = new Node<T>();
        head.setLink(null);
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
        temp.setLink(head.getLink());

        head.setLink(temp);
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
        Node<T> temp = this.head.getLink();

        this.head.setLink(temp.getLink());
        temp.setData(null);
        temp.setLink(null);
    }

    /**
     * The operation has a complexity of O(n), where n is number of elements in the list
     * @param data
     */
    @Override
    public void addToEnd(T data){
        Node<T> dataNode = new Node<>();

        dataNode.setData(data);
        dataNode.setLink(null);

        Node<T> tempHead = this.head;
        while(tempHead.getLink() != null) {
            tempHead = tempHead.getLink();
        }

        tempHead.setLink(dataNode);
    }

    /**
     * Removed a Node from End of the list
     * The operation has a complexity of O(n)
     */
    @Override
    public void removeFromEnd(){
        Node<T> current = this.head;

        Node<T> previous = null;
        while(current.getLink() != null){
            previous = current;
            current = current.getLink();
        }

        //remove current and make previous as last node
        current.setData(null);
        current.setLink(null);

        previous.setLink(null);
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
            while(tempData.getLink() != null){
                tempData = tempData.getLink();
                if(position == index - 1 ) {
                    //Pointing newly added node, to the one pointed to by element at position = index-1
                    dataNode.setLink(tempData.getLink());

                    tempData.setLink(dataNode);
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
            while(current.getLink() != null){
                previous = current;
                current = current.getLink();
                if(position == index) {
                    break;
                }
                position++;
            }

            //remove current and make previous Node point to the node current Node links to.
            previous.setLink(current.getLink());

            current.setData(null);
            current.setLink(null);

        }else {
            throw new IndexOutOfBoundException("Cannot delete Node at the provided location");
        }
    }

    @Override
    public void reverseList() {
        if(getSize() < 1) {
            throw new IndexOutOfBoundException("Cannot reverse an empty list");
        }

        Node<T> current = this.head.getLink();
        Node<T> previous = null;

        while(current != null) {
//            current = current.getLink();
            Node<T> next = current.getLink();
            current.setLink(previous);
            previous = current;

            current = next;
        }

        this.head.setLink(previous);
    }

    @Override
    public void reverseListRecursive(Node node) {
        if(node.getLink() == null) {
            this.head = new Node<>();
            this.head.setLink(node);
            return;
        }else {
            reverseListRecursive(node.getLink());
            Node<T> next = node.getLink();
            if(node.getData() == null){
                next.setLink(null);
            }else {
                node.setLink(null);
                next.setLink(node);
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
        while(tempNode.getLink() != null){
            tempNode = tempNode.getLink();
            size++;
        }
        return size;
    }

    @Override
    public String toString() {
        String listStr = "";
        Node<T> tempNode = this.head;
        while(tempNode.getLink() != null){
            tempNode = tempNode.getLink();
            listStr += tempNode.getData() + " ";
        }
        return listStr;
    }
}
