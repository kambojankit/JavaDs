package com.techarha.training.ds.graph;

import java.util.Arrays;

public class AdjMatrixGraph implements Graph {

    private int NODE_COUNT=5;
    private int vertexCount=0;

    private Integer[][] graphMatrixConnections;
    private Integer[] graphNodeData;


    public AdjMatrixGraph() {
        this.graphMatrixConnections = new Integer[NODE_COUNT][NODE_COUNT];
        this.graphNodeData = new Integer[NODE_COUNT];
        this.initialiseMatrix();
    }

    @Override
    public void addNode(Integer data) {
        if(vertexCount == NODE_COUNT) {
            System.out.println("Resizing container..");
            this.resizeMatrix();
        }

        this.graphNodeData[vertexCount++] = data;
        Arrays.sort(this.graphNodeData, 0, vertexCount);
    }

    @Override
    public void deleteNode(Integer data) {
        //TODO add implementation for deleting the node from graph.
    }

    @Override
    public void addConnection(Integer source, Integer dest) {
        int indexSource = this.findNodeIndex(source);
        int indexDest;
        if(source == dest) {
            indexDest = indexSource;
        }else {
            indexDest = this.findNodeIndex(dest);
        }

        this.graphMatrixConnections[indexSource][indexDest] = 1;
    }

    @Override
    public void deleteConnection(Integer source, Integer dest) {
        int indexSource = this.findNodeIndex(source);
        int indexDest;
        if(source == dest) {
            indexDest = indexSource;
        }else {
            indexDest = this.findNodeIndex(dest);
        }

        this.graphMatrixConnections[indexSource][indexDest] = 0;
    }

    private int findNodeIndex(Integer data) {
        return Arrays.binarySearch(this.graphNodeData,0,vertexCount, data);
    }

    private void resizeMatrix() {
        int previousCount = NODE_COUNT;
        NODE_COUNT = NODE_COUNT * 2;
        Integer[][] temp = new Integer[NODE_COUNT][NODE_COUNT];

        for(int i =0; i<previousCount; i++) {
            temp[i] = Arrays.copyOf(this.graphMatrixConnections[i], NODE_COUNT);
        }
        this.graphMatrixConnections = temp;
        this.graphNodeData = Arrays.copyOf(this.graphNodeData, NODE_COUNT);
        this.initialiseMatrix();
    }

    private void initialiseMatrix() {
        for(int i =0; i<NODE_COUNT; i++) {
            for(int j =0; j<NODE_COUNT; j++) {
                if(graphMatrixConnections[i][j] == null) {
                    graphMatrixConnections[i][j] = 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        String graphString = "   " ;
        for(int i =0; i<vertexCount; i++) {
            graphString += this.graphNodeData[i] + " ";
        }

        graphString += "\n";
//        for(int i =0; i<vertexCount; i++) {
//            graphString += "...";
//        }
//
//        graphString += "\n";

        for(int i =0; i<vertexCount; i++) {
            graphString += this.graphNodeData[i] + "| ";
            for(int j =0; j<vertexCount; j++) {
                graphString += graphMatrixConnections[i][j];
                if(j < vertexCount -1) {
                    graphString += " ";
                }
            }

            graphString += "\n";
        }
        return graphString;
    }
}
