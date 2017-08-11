package com.techarha.training.ds.graph;

import com.techarha.training.ds.list.LinkedList;
import com.techarha.training.ds.list.List;
import com.techarha.training.ds.list.Node;
import com.techarha.training.ds.queue.LinkedListQueue;
import com.techarha.training.ds.queue.Queue;
import com.techarha.training.ds.stack.GenericLinkedListStack;
import com.techarha.training.ds.stack.Stack;
import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.HashSet;

public class AdjListGraph implements Graph<String>{
    private int GRAPH_SIZE = 4;

    private int size=0;

    private AdjListType[] graph;

    public AdjListGraph() {
        this.graph = new AdjListType[GRAPH_SIZE];
    }

    @Override
    public void addNode(String data) {
        if(size == GRAPH_SIZE) {
            this.resizeGraph();
        }
        AdjListType node = new AdjListType();
        node.setData(data);
        this.graph[size++] = node;
        Arrays.sort(this.graph, 0, size);
    }

    @Override
    public void deleteNode(String data) {

    }

    @Override
    public void addConnection(String source, String target) {
        int sourceInd = this.findIndex(source);
        int targetInd = this.findIndex(target);

        if(source != target) {
            this.graph[sourceInd].addIndexToNode(targetInd);
        }
    }

    @Override
    public void deleteConnection(String source, String target) {
        //TODO implement connection deletion
    }

    @Override
    public void breadthFirstTraversal(String data) {
        this.breadthFirstTraversal(findIndex(data));
    }

    @Override
    public void depthFirstTraversal(String data) {
        this.depthFirstTraversal(findIndex(data));
    }


    /**
     * //TODO Implementation of topological sort
     *
     * for a directed Acyclic graph (DAG), its a linear ordering of vertices such that,
     * for every directed edge(u,v), vertex u comes before v in ordering.
     *
     * Advantages and uses of Topological sorting:
     *  a) Build System like ANT or Maven etc
     *  b) Advanced-package tool (apt-get)
     *  c) Task Scheduling
     *  d) pre-requisite related problems.
     *
     */
    public void topologicalSort() {
        HashSet<String> visited = new HashSet<>();
        java.util.Stack<AdjListType> stack = new java.util.Stack<>();

        for(AdjListType node : this.graph) {
            if(node != null && !visited.contains(node.getData())) {
                this.topologicalSort(node, visited, stack);
            }
        }
//        for (AdjListType top: stack) {
//            System.out.print(top.getData()+ " ");
//        }
        System.out.println(stack);
        System.out.println("Stack Top: " + stack.peek());
    }


    private void topologicalSort(AdjListType source, HashSet<String> visited, java.util.Stack<AdjListType> stack) {
        LinkedList list = source.getList();
        visited.add(source.getData());
        Node<Integer> node = list.getHead().getNext();

        while(node != null) {
            AdjListType temp = this.graph[node.getData()];
            if(!visited.contains(temp.getData())) {
                topologicalSort(temp, visited, stack);
            }


            node = node.getNext();
        }

        stack.push(source);
    }

    private void breadthFirstTraversal (int index) {
        Queue<AdjListType> queue = new LinkedListQueue<>();
        queue.enqueue(this.graph[index]);

        while(!queue.isEmpty()) {
            AdjListType current = queue.front();
            queue.dequeue();
            if(!current.isVisited()) {
                System.out.print(current.getData()+ " ");
            }
            current.setVisited(true);
            List list = current.getList();
            Node<Integer> node = list.getHead().getNext();
            while(node != null) {
                AdjListType temp = this.graph[node.getData()];
                if(!temp.isVisited()) {
                    queue.enqueue(temp);
                }
                node = node.getNext();
            }
        }

        for(int i=0; i<size; i++) {
            this.graph[i].setVisited(false);
        }
        System.out.println("\n");
    }

    private void depthFirstTraversal (int index) {
        Stack<AdjListType> stack = new GenericLinkedListStack<>();
        stack.push(this.graph[index]);

        while(!stack.isEmpty()) {
            AdjListType current = stack.top();
            stack.pop();

            if(!current.isVisited()) {
                System.out.print(current.getData()+ " ");
            }
            current.setVisited(true);
            List list = current.getList();
            Node<Integer> node = list.getHead().getNext();
            while(node != null) {
                AdjListType topNode = this.graph[node.getData()];
                if(!topNode.isVisited()) {
                    stack.push(topNode);
                }
                node = node.getNext();
            }
        }

        for(int i=0; i<size; i++) {
            this.graph[i].setVisited(false);
        }
        System.out.println("\n");
    }

    private int findIndex(String data) {
        return Arrays.binarySearch(this.graph, 0, size, new AdjListType(data));
    }

    private void resizeGraph() {
        System.out.println("Resizing Graph");
        this.GRAPH_SIZE = 2*this.GRAPH_SIZE;
        this.graph = Arrays.copyOf(this.graph, this.GRAPH_SIZE);
    }

    @Override
    public String toString() {
        String buff = "";
        for(int i=0; i<size; i++) {
            buff += this.graph[i]+ ": ";

            List list = this.graph[i].getList();
            Node<Integer> node = list.getHead().getNext();
            while(node != null) {
                buff += this.graph[node.getData()]+ " ";
                node = node.getNext();
            }
            buff += "\n";
        }
        return buff;
    }
}
