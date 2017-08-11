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

    public static void basicGraphAdjancey() {
        Graph<String> adjListGraph = new AdjListGraph();

        adjListGraph.addNode("5");
        adjListGraph.addNode("1");
        adjListGraph.addNode("6");
        adjListGraph.addNode("9");
        adjListGraph.addNode("3");
        adjListGraph.addNode("4");

        adjListGraph.addConnection("5", "6");
        adjListGraph.addConnection("5", "9");
        adjListGraph.addConnection("6", "9");
        adjListGraph.addConnection("6", "3");
        adjListGraph.addConnection("6", "5");
        adjListGraph.addConnection("9", "5");
        adjListGraph.addConnection("9", "6");
        adjListGraph.addConnection("9", "1");
        adjListGraph.addConnection("9", "4");
        adjListGraph.addConnection("1", "9");
        adjListGraph.addConnection("4", "9");
        adjListGraph.addConnection("4", "3");
        adjListGraph.addConnection("3", "4");
        adjListGraph.addConnection("3", "6");

        System.out.println(adjListGraph);

        adjListGraph.breadthFirstTraversal("9");
        adjListGraph.breadthFirstTraversal("1");
        adjListGraph.breadthFirstTraversal("3");
        adjListGraph.breadthFirstTraversal("4");
        adjListGraph.breadthFirstTraversal("6");
        adjListGraph.breadthFirstTraversal("5");
        adjListGraph.depthFirstTraversal("5");

        System.out.print("Topological Traversal: ");
        ((AdjListGraph)adjListGraph).topologicalSort();
    }

    public static void testTopologicalSort() {
        AdjListGraph graph = new AdjListGraph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("H");
        graph.addNode("I");
        graph.addNode("J");

        graph.addConnection("A", "B");
        graph.addConnection("A", "F");

        graph.addConnection("B", "H");

        graph.addConnection("G", "A");
        graph.addConnection("G", "B");
        graph.addConnection("G", "C");

        graph.addConnection("D", "C");
        graph.addConnection("D", "I");
        graph.addConnection("D", "E");
        graph.addConnection("D", "H");

        graph.addConnection("J", "E");

        graph.addConnection("E", "I");

        graph.addConnection("I", "C");

        System.out.println(graph);

        System.out.print("Topological Traversal: ");
        graph.topologicalSort();
    }
}
