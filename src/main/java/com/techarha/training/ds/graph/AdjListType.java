package com.techarha.training.ds.graph;

import com.techarha.training.ds.list.LinkedList;

public class AdjListType implements Comparable<AdjListType>{
    private String data;
    private LinkedList<Integer> list;
    private boolean isVisited;

    public AdjListType() {
        this.list = new LinkedList<Integer>();
    }
    public AdjListType(String data) {
        this();
        this.setData(data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LinkedList<Integer> getList() {
        return list;
    }

    public void addIndexToNode(Integer index) {
        this.list.addToEnd(index);
    }

    public void deleteIndexToNode(Integer index) {
        //TODO Implement deletion here
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return data;
    }

    @Override
    public int compareTo(AdjListType s) {
        return this.data.compareTo(s.getData());
    }

    @Override
    public boolean equals(Object o) {
        return this.data.equals(((AdjListType)o).getData());
    }
}
