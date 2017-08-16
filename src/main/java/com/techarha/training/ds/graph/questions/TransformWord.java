package com.techarha.training.ds.graph.questions;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given two words (start and end), a dictionary of N words find the shortest path
 * to convert Start to end word.
 * given:
 *  1) assume two words are of same length
 *  2) only one character may be changed at a time
 *  3) each time a word is modified, it should be a match in dictionary.
 *
 */
public class TransformWord {

    private static HashMap<String, Node> nodeLookup = new HashMap<>();

    public static class Node {
        private String data;
        private LinkedList<Node> adjList;

        private Node() {
            this.adjList = new LinkedList<>();
        }

        public String getData() {
            return this.data;
        }
    }

    private static Node getNode(String data) {
        return nodeLookup.get(data);
    }

    private static int traverseBFS(String startData, String endWord) {
        int stepCount=0;
        Node startNode = getNode(startData);
        LinkedList<Node> nodeQueue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        nodeQueue.add(startNode);

        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.peek();
            nodeQueue.remove();

            if(visited.contains(current.getData())) {
                continue;
            }
            System.out.print(current.getData() + " -> ");
            stepCount++;
            visited.add(current.getData());

            if(current.getData().equals(endWord)) {
                break;
            }

            for(Node child: current.adjList) {
                if(!visited.contains(child.getData())) {
                    nodeQueue.add(child);
                }
            }

        }
        return stepCount;
    }

    private static void prepareDictionaryGraph(HashSet<String> dictionary) {
        //Add Nodes
        for(String value: dictionary) {
            Node node = new Node();
            node.data = value;

            nodeLookup.put(value, node);
        }

        //Setup graph adjacency list
        for(Map.Entry<String, Node> entry: nodeLookup.entrySet()) {
            List<String> samples = findAllNextWords(entry.getKey(), dictionary);
            for (String sample: samples) {
                if(sample != null) {
                    Node match = getNode(sample);
                    entry.getValue().adjList.add(match);
                }
            }
        }

    }

    private static List<String> findAllNextWords(String word, HashSet<String> dictionary) {
        List<String> match = new ArrayList<String>();
        char[] wordCharArr = word.toCharArray();

        for(String value: dictionary) {
            char[] charArr = value.toCharArray();
            boolean[] isMatch = new boolean[value.length()];
            for(int i = 0; i<value.length(); i++) {
                isMatch[i] = charArr[i] == wordCharArr[i];
            }

            int count = 0;
            for(int i = 0; i<value.length(); i++) {
                if(isMatch[i]) {
                    count++;
                }
            }
            if(count == value.length()-1) {
                match.add(value);
            }
        }
        return match;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String startWord = br.readLine().trim().toLowerCase();
        String endWord = br.readLine().trim().toLowerCase();

        String line = br.readLine();
        int N = Integer.parseInt(line.trim());


        HashSet<String> dictionary = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            dictionary.add(br.readLine().trim().toLowerCase());
        }

        if(startWord.equals(endWord)) {
            System.out.println(0);
            return;
        }

        int startLength = startWord.length();
        int endLength = endWord.length();

        if(startLength != endLength) {
            System.out.println(0);
            return;
        }

        prepareDictionaryGraph(dictionary);

        int stepCount = 0;
        String startNode;
        String endNode;

        System.out.println("========== STEPS =========");

        if(dictionary.contains(startWord)) {
            startNode = startWord;
            System.out.println(startNode + " -> ");
        }else {
            List<String> temp = findAllNextWords(startWord, dictionary);
            startNode = temp.size() > 0
                            ? findAllNextWords(startWord, dictionary).get(0)
                            : null;
            System.out.print(startWord + " -> ");
            stepCount++;
        }

        if(dictionary.contains(endWord)) {
            endNode = endWord;
        }else {
            List<String> temp = findAllNextWords(endWord, dictionary);
            endNode = temp.size() > 0
                    ? findAllNextWords(endWord, dictionary).get(0)
                    : null;
        }

        if(startNode == null || endNode == null) {
            System.out.println(-1);
            return;
        }

        int finalSteps =  traverseBFS(startNode, endNode) + stepCount;

        if(!endNode.equals(endWord)) {
            System.out.print(endWord);
        }

        System.out.println("\n==========================");
        System.out.println(finalSteps);
    }

}
