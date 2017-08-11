package com.techarha.training.ds.graph;

public interface Graph<T> {
    void addNode(T data);

    void deleteNode(T data);

    void addConnection(T source, T dest);

    void deleteConnection(T source, T dest);

    void breadthFirstTraversal(String data);

    void depthFirstTraversal(String data);
}
