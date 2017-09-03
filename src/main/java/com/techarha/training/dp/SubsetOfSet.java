package com.techarha.training.dp;

import java.util.ArrayList;

public class SubsetOfSet {
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(findAllSubsets(set, 0));

    }

    private static ArrayList<ArrayList<Integer>> findAllSubsets(ArrayList<Integer> set, int index) {

        ArrayList<ArrayList<Integer>> allSubsets;

        if(set.size() == index) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<>());
        }else {
            allSubsets = findAllSubsets(set, index + 1);
            System.out.println(allSubsets);
            Integer item = set.get(index);

            ArrayList<ArrayList<Integer>> newFullSubSet = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset: allSubsets) {
                ArrayList<Integer> subsetCache = new ArrayList<Integer>();
                subsetCache.addAll(subset);
                subsetCache.add(item);
                newFullSubSet.add(subsetCache);
            }
            allSubsets.addAll(newFullSubSet);
        }
        return allSubsets;
    }
}
