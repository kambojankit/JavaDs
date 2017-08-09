package com.techarha.training.ds.tree;

import com.techarha.training.ds.queue.LinkedListQueue;
import com.techarha.training.ds.queue.Queue;

public class LinkedTree {
    BstNode<Integer> root;

    public LinkedTree() {

    }

    public BstNode<Integer> getRoot() {
        return root;
    }

    public void insert(Integer data) {
        this.root = iterativeInsert(this.root, data);
    }

    public Integer getMin() {
        return this.minValueRecursive(this.root);
    }

    public  Integer getMax() {
        return this.maxValueRecursive(this.root);
    }

    public Integer getHeight() {
        return this.getTreeHeight(this.root);
    }

    public void traversePreOrderRec() {
        this.preOrderTraversal(this.root);
    }

    /**
     * TODO traverse the tree PreOrder Iteratively
     */
    public void traversePreOrderIterative() {

    }

    public void traverseInOrderRec() {
        this.inOrderTraversal(this.root);
    }

    /**
     * TODO traverse the tree InOrder Iteratively
     */
    public void traverseInOrderIter() {

    }

    public void traversePostOrderRec() {
        this.postOrderTraversal(this.root);
    }

    /**
     * TODO traverse the tree PostOrder Iteratively
     */
    public void traversePostOrderIter() {
        this.postOrderTraversal(this.root);
    }

    public void breadthFirstTraversal() {
        this.levelOrderTraversal(this.root);
    }

    public BstNode<Integer> deleteNode(Integer data) {
        return this.deleteNode(this.root, data);
    }

    public LinkedTree deleteNodeIntoTree(Integer data) {
        LinkedTree tree = new LinkedTree();
        tree.root = this.deleteNode(this.root, data);
        return tree;
    }

    private BstNode<Integer> deleteNode(BstNode<Integer> root, Integer data) {
        //Check if root null
        if(root == null) return root;
        else if (data < root.getData()) root.setLeft(deleteNode(root.getLeft(), data));
        else if (data > root.getData()) root.setRight(deleteNode(root.getRight(), data));
        else {
            if(root.getLeft() == null && root.getRight() == null) {
                //case 1: no child
                root = null;
            }else if(root.getRight() == null) {
                //case 2: node has left child only
                BstNode<Integer> leftChild = root.getLeft();
                root.setLeft(null);
                root.setData(null);
                root = leftChild;
            }else if(root.getLeft() == null) {
                //case 2: node has right child only
                BstNode<Integer> rightChild = root.getRight();
                root.setRight(null);
                root.setData(null);
                root = rightChild;
            }else {
                //case 3: has both child
                Integer rightMin = this.minValueRecursive(root.getRight());
                root.setData(rightMin);
                root.setRight(deleteNode(root.getRight(), rightMin));
            }
        }
        return root;
    }

    private BstNode<Integer> findNode(BstNode<Integer> root, Integer data) {
        if(root == null) return null;

        if(root.getData() == data) {
            return root;
        }

        if(data < root.getData()) {
            return findNode(root.getLeft(), data);
        }else {
            return findNode(root.getRight(), data);
        }
    }

    /**
     * Recursive way to implement a BST insertion
     * @param bsRoot
     * @param data
     * @return
     */
    private BstNode<Integer> recursiveInsert(BstNode<Integer> bsRoot, Integer data) {
        if(bsRoot == null) {
            bsRoot = new BstNode<>();
            bsRoot.setData(data);
            return bsRoot;

        }else if(bsRoot.getData() >= data) {
            //insert to left node
            bsRoot.setLeft(recursiveInsert(bsRoot.getLeft(), data));
        }else {
            // insert to right node
            bsRoot.setRight(recursiveInsert(bsRoot.getRight(), data));
        }

        return bsRoot;
    }

    /**
     * iterative insertion implementation
     */
    private BstNode<Integer> iterativeInsert(BstNode<Integer> bsRoot, Integer data) {
        BstNode<Integer> tempRoot = bsRoot;
        if(tempRoot == null ) {
            bsRoot = new BstNode<>();
            bsRoot.setData(data);
            return bsRoot;
        }

        while(tempRoot != null){
            if(data <= tempRoot.getData()) {
                if(tempRoot.getLeft() == null) {
                    BstNode<Integer> temp = new BstNode<>();
                    temp.setData(data);
                    tempRoot.setLeft(temp);
                    break;
                }

                tempRoot= tempRoot.getLeft();

            }else {
                if(tempRoot.getRight() == null) {
                    BstNode<Integer> temp = new BstNode<>();
                    temp.setData(data);
                    tempRoot.setRight(temp);
                    break;
                }

                tempRoot= tempRoot.getRight();
            }
        }
        return bsRoot;
    }

    private Integer minValueIterative() {
        Integer result = null ;
        BstNode<Integer> temp = this.root;
        result = temp.getData();
        while(temp.getLeft() != null) {
            temp = temp.getLeft();
            result = temp.getData();
        }
        return result;
    }

    private Integer minValueRecursive (BstNode<Integer> root) {
        if(root.getLeft() == null) {
            return root.getData();
        }else {
            return minValueRecursive(root.getLeft());
        }
    }

    private Integer maxValueIterative() {
        Integer result = null ;
        BstNode<Integer> temp = this.root;
        result = temp.getData();
        while(temp.getRight() != null) {
            temp = temp.getRight();
            result = temp.getData();
        }
        return result;
    }

    private Integer maxValueRecursive (BstNode<Integer> root) {
        if(root.getRight() == null) {
            return root.getData();
        }else {
            return maxValueRecursive(root.getRight());
        }
    }

    private Integer getTreeHeight(BstNode<Integer> root) {
        Integer left;
        Integer right;

        if(root.getLeft() == null ) {
            left = -1;
        }else {
            left = getTreeHeight(root.getLeft());
        }

        if(root.getRight() == null ) {
            right = -1;
        }else {
            right = getTreeHeight(root.getRight());
        }

        return this.maxInt(left, right) + 1;

    }

    private Integer maxInt(Integer left, Integer right) {
        if(left < 0) return right;
        if(right < 0) return left;

        return left - right >= 0? left : right;
    }

    private void levelOrderTraversal(BstNode<Integer> root) {
        if(root == null) return;
        Queue<BstNode<Integer>> queue = new LinkedListQueue<>();
        BstNode<Integer> tempRoot = root;
        queue.enqueue(tempRoot);
        while(!queue.isEmpty()){
            BstNode<Integer> temp = queue.front();
            queue.dequeue();
            if(temp.getLeft() != null) {
                queue.enqueue(temp.getLeft());
            }
            if(temp.getRight() != null) {
                queue.enqueue(temp.getRight());
            }
            processRoot(temp.getData());

        }
    }

    /**
     * A tree traversal where we process tree as --> <Root> <Left> <Right>
     * @param root
     */
    private void preOrderTraversal(BstNode<Integer> root) {
        if(root == null) return;
        processRoot(root.getData());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    /**
     * A tree traversal where we process tree as --> <Left> <Root> <Right>
     * @param root
     */
    private void inOrderTraversal(BstNode<Integer> root) {
        if(root == null) return;
        inOrderTraversal(root.getLeft());
        processRoot(root.getData());
        inOrderTraversal(root.getRight());
    }

    /**
     * A tree traversal where we process tree as --> <Left> <Right> <Root>
     * @param root
     */
    private void postOrderTraversal(BstNode<Integer> root) {
        if(root == null) return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        processRoot(root.getData());
    }

    private void processRoot(Integer data) {
        System.out.print(data + " ");
    }
}
