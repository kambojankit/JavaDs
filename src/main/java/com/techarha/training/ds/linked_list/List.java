package com.techarha.training.ds.linked_list;

public interface List<T> {
    Node<T> getHead();

    void addToFront(T data);

    void removeFromFront();

    void addToEnd(T data);

    void removeFromEnd();

    void insertAt(T data, int index);

    void removeAt(int index);

    void reverseList();

    void reverseListRecursive(Node node);

    Integer getSize();
}
