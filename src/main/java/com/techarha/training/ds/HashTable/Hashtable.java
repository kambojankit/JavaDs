package com.techarha.training.ds.HashTable;

import com.techarha.training.ds.list.LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Hashtable<K, T> {
    private int CAPACITY = 13;
    LinkedList<HashNode<K, T> >[] data;

    public Hashtable(Class<T> clazz) {
        data = (LinkedList<HashNode<K, T> >[]) Array.newInstance(clazz, CAPACITY);
    }

    public void add(K key, T data) {
        int hashCode = key.hashCode() % CAPACITY;
        if(this.data[hashCode] == null ) {
            this.data[hashCode] = new LinkedList<>();
        }

        HashNode node = new HashNode();
        node.setKey(key);
        node.setValue(data);

        /**
         * Here we are using a self created implementation of linked list, which currently does
         * not support finding an element by using object equals.
         * These support will be added in coming future version of the code.
         *
         * What ends up happening is, multiple values with same Key will be added,
         * but on search the first match will be returned.
         *
         */
        this.data[hashCode].addToEnd(node);
    }

    private static class HashNode<K, T> {
        K key;
        T value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
