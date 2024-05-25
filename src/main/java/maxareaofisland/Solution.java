package maxareaofisland;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    maxIsland = Math.max(maxIsland, calculateArea(r, c, grid));
                }
            }
        }
        return maxIsland;
    }

    public int calculateArea(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + calculateArea(r - 1, c, grid) + calculateArea(r + 1, c, grid) + calculateArea(r, c - 1, grid) + calculateArea(r, c + 1, grid);
    }
}
