package com.techarha.training.ds.graph;

public class GraphTest {

    public static void basicGraphMatrix() {
        Graph matrixGraph = new AdjMatrixGraph();

        matrixGraph.addNode(5);
        matrixGraph.addNode(1);
        matrixGraph.addNode(6);
        matrixGraph.addNode(9);
        matrixGraph.addNode(3);
        matrixGraph.addNode(4);

        matrixGraph.addConnection(5, 6);
        matrixGraph.addConnection(5, 9);
        matrixGraph.addConnection(6, 9);
        matrixGraph.addConnection(6, 3);
        matrixGraph.addConnection(6, 5);
        matrixGraph.addConnection(9, 5);
        matrixGraph.addConnection(9, 6);
        matrixGraph.addConnection(9, 1);
        matrixGraph.addConnection(9, 4);
        matrixGraph.addConnection(1, 9);
        matrixGraph.addConnection(4, 9);
        matrixGraph.addConnection(4, 3);
        matrixGraph.addConnection(3, 4);
        matrixGraph.addConnection(3, 6);

        System.out.println(matrixGraph);

    }
}
