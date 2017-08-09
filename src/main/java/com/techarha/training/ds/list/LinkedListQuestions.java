package com.techarha.training.ds.list;

public class LinkedListQuestions {
    /**
     * Detect a circle in Linked List.
     */
    public static boolean isListCyclic(List list) {
        if(list.getHead() == null || list.getHead().getNext() == null) return false;

        Node slowNode = list.getHead();
        Node fastNode = list.getHead().getNext();

        while(fastNode != null) {
            if(fastNode == slowNode) {
                return true;
            }
            if(fastNode.getNext() != null) {
                return false;
            }
            fastNode = fastNode.getNext().getNext();
            slowNode = slowNode.getNext();
        }
        return false;
    }
}
