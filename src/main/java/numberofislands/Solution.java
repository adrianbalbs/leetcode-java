package numberofislands;

public class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    num++;
                    dfs(r, c, grid);
                }
            }
        }
        return num;
    }

    void dfs(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(r - 1, c, grid);
        dfs(r + 1, c, grid);
        dfs(r, c - 1, grid);
        dfs(r, c + 1, grid);
    }
}
