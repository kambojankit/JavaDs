package com.techarha.training.ds.graph;

public interface Graph {
    void addNode(Integer data);

    void deleteNode(Integer data);

    void addConnection(Integer source, Integer dest);

    void deleteConnection(Integer source, Integer dest);
}
