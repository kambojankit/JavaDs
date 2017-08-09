package com.techarha.training.ds.tree;

import com.techarha.training.ds.stack.GenericArrayStack;
import com.techarha.training.ds.stack.Stack;

public class TreeUtils {

    public static boolean isBst(BinaryLinkedTree tree) {
        boolean isBst = false;
        //Using a natural recursive solution
//        isBst = checkBstRecursive(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        Stack<Integer> intStack = new GenericArrayStack<>(Integer.class);
        intStack.push(Integer.MIN_VALUE);
        isBst = checkBstUsingInorder(tree.getRoot(), intStack);
        return isBst;
    }

    private static boolean checkBstRecursive(BstNode<Integer> root, Integer min, Integer max) {
        boolean leftCheck, rightCheck;
        if(root.getLeft() == null) {
            leftCheck = root.getData() <= max;
        }else {
            leftCheck = checkBstRecursive(root.getLeft(), min, root.getData());
        }

        if(root.getRight() == null) {
            rightCheck = root.getData() > min;
        }else {
            rightCheck = checkBstRecursive(root.getRight(), root.getData(), max);
        }

        return leftCheck && rightCheck;
    }

    /**
     * Inorder taversal to check if tree is a BST
     * @param root
     */
    private static boolean checkBstUsingInorder(BstNode<Integer> root, Stack<Integer> accumulator) {
        if(root == null) return true;
        checkBstUsingInorder(root.getLeft(), accumulator);
        boolean isBst = processRoot(root.getData(), accumulator);
        if(!isBst) {
            return false;
        }
        checkBstUsingInorder(root.getRight(), accumulator);
        return true;
    }

    private static boolean processRoot(Integer data, Stack<Integer> accumulator) {
        if(!accumulator.isEmpty() && accumulator.top() <= data){
            accumulator.push(data);
            return true;
        }else {
            return false;
        }
    }
}
