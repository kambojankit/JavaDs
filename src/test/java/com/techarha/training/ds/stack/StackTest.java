package com.techarha.training.ds.stack;

import com.techarha.training.ds.list.LinkedList;
import com.techarha.training.ds.list.List;
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
     * TODO: Question:: Reverse a linked list using stack
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

    /**
     * TODO: Question:: Count the provided string for the balanced parenthesis.
     */
    public static int countBalancedParanthesis(String input) {
        Stack<Character> stack = new GenericLinkedListStack<>();
        int balancedCount = 0;
        char[] charArr = input.toCharArray();
        for(char ch : charArr) {
            switch (ch) {
                case '{':
                    stack.push(ch);
                    break;
                case '[':
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case '<':
                    stack.push(ch);
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.top()== '{') {
                        balancedCount++;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.top()== '[') {
                        balancedCount++;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.top()== '(') {
                        balancedCount++;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                case '>':
                    if(!stack.isEmpty() && stack.top()== '<') {
                        balancedCount++;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
            }
        }
        return balancedCount;
    }

    /**
     * Question:: Test if the provided string is balanced parenthesis.
     */
    public static boolean isBalancedParanthesis(String input) {
        Stack<Character> stack = new GenericLinkedListStack<>();

        char[] charArr = input.toCharArray();
        for(char ch : charArr) {
            switch (ch) {
                case '{':
                    stack.push(ch);
                    break;
                case '[':
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case '<':
                    stack.push(ch);
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.top()== '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.top()== '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.top()== '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '>':
                    if(!stack.isEmpty() && stack.top()== '<') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    /**
     * TODO: Question:: Write code to convert Infix expression (without parenthesis)provided in a string to postfix.
     *
     */
    public static String infixToPostfix(String input) {
        //TODO 1. handle spaces in the input expression
        //TODO 2. handle tokenisation of operands, for example to handle 54+2 (Note: current implementation handles 54 as 5 and 4 separately.
        char[] expression = input.toCharArray();
        List<Character> postFix = new LinkedList<>();
        Stack<Character> stack = new GenericLinkedListStack<>();
        for(char ch: expression) {
            switch (ch) {
                case '+':
                case '-':
                case '/':
                case '*':
                    if(!stack.isEmpty() && isTopHigherPrecedence(stack.top(), ch)) {
                        while(!stack.isEmpty()) {
                            postFix.addToFront(stack.top());
                            stack.pop();
                        }
                        stack.push(ch);
                    }else {
                        stack.push(ch);
                    }
                    break;
                default:
                    postFix.addToFront(ch);
            }
        }
        while(!stack.isEmpty()) {
            postFix.addToFront(stack.top());
            stack.pop();
        }
        postFix.reverseList();
        return postFix.toString();
    }

    /**
     * TODO: Question:: Write code to convert Infix expression (with parenthesis) provided in a string to postfix.
     *
     */
    public static String infixToPostfixWithParen(String input) {
        //TODO implement your code here.

        return null;
    }

    private static boolean isTopHigherPrecedence(char top, char exp) {
        boolean isHigher = false;
        switch (top) {
            case '+':
                if(exp == '+' || exp == '-')
                    isHigher = false;
                else
                    isHigher = true;
            case '-':
                if(exp == '+' || exp == '-')
                    isHigher = false;
                else
                    isHigher = true;
            case '/':
                if(exp == '+' || exp == '-')
                    isHigher = true;
                else
                    isHigher = false;
            case '*':
                if(exp == '+' || exp == '-')
                    isHigher = true;
                else
                    isHigher = false;
        }
        return isHigher;
    }
}
