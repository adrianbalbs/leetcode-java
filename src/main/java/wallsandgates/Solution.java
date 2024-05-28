package wallsandgates;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0} };
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int row = curr[0], col = curr[1];
            for (int[] d : directions) {
                int x = row + d[0];
                int y = col + d[1];
                if (x >= m || y >= n || x < 0 || y < 0 || grid[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[x][y] = grid[row][col] + 1;
                q.add(new int[] {x, y});
            }
        }
    }
}
