package com.techarha.training.ds.tree;

public class LinkedTree {
    BstNode<Integer> root;

    public LinkedTree() {

    }

    public void insert(Integer data) {
        this.root = iterativeInseret(this.root, data);
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
     * TODO Quesiton:: provide iterative insertion implementation
     */
    private BstNode<Integer> iterativeInseret(BstNode<Integer> bsRoot, Integer data) {
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
}
