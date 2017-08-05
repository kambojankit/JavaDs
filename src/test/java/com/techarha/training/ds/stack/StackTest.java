package com.techarha.training.ds.stack;

import com.techarha.training.ds.list.LinkedList;
import com.techarha.training.ds.list.Node;

public class StackTest {
    public static void basicStringArrayTest() {
        Stack<String> stringStack = new StringArrayStack();

        stringStack.push("Hello");
        stringStack.push("Bye");
        stringStack.push("Hi");

        System.out.println(stringStack);

        System.out.println(stringStack.top());

        stringStack.pop();
        stringStack.push("gone");
        System.out.println(stringStack);
    }

    public static void basicGenericArrayTest() {
        Stack<Integer> intStack = new GenericArrayStack<Integer>(Integer.class);

        intStack.push(120);
        intStack.push(345);

        System.out.print(intStack);

        intStack.push(900);
        intStack.push(2311);
        System.out.print(intStack);

        intStack.push(12);

        System.out.println(intStack);

        System.out.println(intStack.top());

        intStack.pop();
        intStack.push(800);
        intStack.push(7878);
        System.out.println(intStack);
    }

    public static void basicGenericLinkedListStackTest() {
        Stack<Integer> intStack = new GenericLinkedListStack<Integer>();

        intStack.push(120);
        intStack.push(345);

        System.out.println(intStack);

        intStack.push(900);
        intStack.push(2311);
        System.out.println(intStack);

        intStack.push(12);

        System.out.println(intStack);

        System.out.println(intStack.top());

        intStack.pop();
        intStack.push(800);
        intStack.push(7878);
        System.out.println(intStack);
    }

    /**
     * TODO Question: Reverse a linked list using stack
     */
    public static void reverseLinkedList(LinkedList<String> list) {
        Stack<Node> stack = new GenericLinkedListStack<Node>();

        System.out.println("Input: " + list);
        Node<String> node = list.getHead();
        while(node.getNext() != null) {
            node = node.getNext();
            stack.push(node);
        }

        node = list.getHead();
        while(!stack.isEmpty()) {
            Node<String> temp = stack.top();
            temp.setNext(null);
            node.setNext(temp);
            node = temp;
            stack.pop();
        }

        System.out.println("Output: " + list);
    }
}