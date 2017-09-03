package com.techarha.training.dp;

public class RobotInGrid {
    public static void main(String[] args) {
        boolean[][] grid = {
                {true, false, false, false, false, false},
                {true, false, false, false, false, false},
                {true, true, true, true, false, false},
                {false, false,false, true, true, true}
        };

        System.out.println("Can robot Reach the end: " + findPath(grid, grid.length-1, grid[0].length-1));
    }

    /**
     * Basic Implementation to find the path for a robot from a starting grid Position to last element of  grid
     * //TODO write a memoize to enhance Algo's performance.
     */
    private static boolean findPath(boolean[][] pathGrid, int lastRowIndex, int lastColumnIndex) {
        if(lastRowIndex == 0 && lastColumnIndex == 0 ) return true;
        if(lastColumnIndex < 0 || lastRowIndex < 0) return false;

        boolean canReachFromTop = false;
        if(pathGrid[lastRowIndex][lastColumnIndex]) {
            canReachFromTop = findPath(pathGrid, lastRowIndex, lastColumnIndex -1);
        }

        boolean canReachFromLeft= false;
        if(pathGrid[lastRowIndex][lastColumnIndex]){
            canReachFromLeft = findPath(pathGrid, lastRowIndex -1, lastColumnIndex);
        }

        return canReachFromLeft || canReachFromTop;
    }
}
