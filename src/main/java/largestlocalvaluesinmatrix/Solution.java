package largestlocalvaluesinmatrix;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxGrid = new int[n - 2][n - 2];
        for (int i = 0; i < maxGrid.length; i++) {
            for (int j = 0; j < maxGrid.length; j++) {
                maxGrid[i][j] = findMax(grid, i, j);
            }
        }
        return maxGrid;
    }

    int findMax(int[][]grid, int x, int y) {
        int maxElem = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                maxElem = Math.max(maxElem, grid[i][j]);
            }
        }
        return maxElem;
    }
}
