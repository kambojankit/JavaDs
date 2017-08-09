package com.techarha.training.ds.tree;

public class BstNode<T> {
    private T data;
    private BstNode<T> right;
    private BstNode<T> left;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BstNode<T> getRight() {
        return right;
    }

    public void setRight(BstNode<T> right) {
        this.right = right;
    }

    public BstNode<T> getLeft() {
        return left;
    }

    public void setLeft(BstNode<T> left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }
}
