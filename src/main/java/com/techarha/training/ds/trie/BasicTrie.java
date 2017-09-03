package com.techarha.training.ds.trie;

public class BasicTrie {
    public static class Node {
        private static int numberOfCharacter = 26;
        Node[] children = new Node[numberOfCharacter];
        int size;

        public void add(String s) {
            this.add(s,0);
        }

        private static int getCharIndex(char ch) {
            return ch - 'a';
        }

        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        private void add(String s, int index) {
            size++;
            if(s.length() == index) return;

            char current = s.charAt(index);
            int currentCharIndex = getCharIndex(current);

            Node child = getNode(current);
            if(child == null) {
                child = new Node();
                setNode(current, child);
            }
            child.add(s, index+ 1);
        }

        public int findCount(String s, int index) {
            if(s.length() == index) {
                return size;
            }

            Node child = getNode(s.charAt(index));
            if(child == null) {
                return 0;
            }

            return child.findCount(s, index + 1);
        }
    }
}
