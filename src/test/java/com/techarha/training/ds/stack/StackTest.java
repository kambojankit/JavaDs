package com.techarha.training.ds.stack;

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
        intStack.push(900);

        System.out.println(intStack);

        System.out.println(intStack.top());

        intStack.pop();
        intStack.push(800);
        System.out.println(intStack);
    }
}
