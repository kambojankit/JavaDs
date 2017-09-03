package com.techarha.training.dp;

public class StepsOnStaircase {
    public static void main(String[] args) {
        System.out.println(new StepsOnStaircase().stepsNeeded(4));
    }

    private Integer stepsNeeded(Integer stairNum) {
        if(stairNum < 0) return 0;
        if(stairNum == 0) return 1;
        return stepsNeeded(stairNum - 1) + stepsNeeded(stairNum - 2) + stepsNeeded(stairNum - 3);
    }
}
