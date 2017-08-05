package com.techarha.training.ds.linked_list;

public class Node<T>{
    T data;
    Node<T> link;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLink() {
        return link;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        if(data != null ) {
            return data.toString();
        }else {
            return "null";
        }
    }
}
