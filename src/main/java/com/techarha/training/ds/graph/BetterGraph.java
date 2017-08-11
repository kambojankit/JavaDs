package com.techarha.training.ds.graph;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class BetterGraph {
    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    private void addEdge(int source, int target) {
        Node s = nodeLookup.get(source);
        Node d = nodeLookup.get(target);

        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int target) {
        Node s = getNode(source);
        Node d = getNode(target);

        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    public boolean hasPathBFS(int source, int target) {
        Node s = getNode(source);
        Node d = getNode(target);

        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node target, HashSet<Integer> visited) {
        if(visited.contains(source.id)) return false;

        visited.add(source.id);
        if(source ==  target) {
            return true;
        }

        for(Node child: source.adjacent) {
            if(hasPathDFS(child, target, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPathBFS(Node source, Node target, HashSet<Integer> visited) {
        LinkedList<Node> nextToVisit = new LinkedList<Node>();

        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if(node == target) {
                return true;
            }

            if(visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);

            for (Node child: node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
