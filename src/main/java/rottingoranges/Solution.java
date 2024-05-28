package rottingoranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int oranges = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    ++oranges;
                }
            }
        }

        int time = 0;
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty() && oranges != 0) {
            ++time;
            int qLen = q.size();
            for (int i = 0; i < qLen; ++i) {
                int[] square = q.remove();
                int row = square[0];
                int col = square[1];
                for (int[] dir : directions) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (
                        x >= n ||
                        y >= m ||
                        x < 0 ||
                        y < 0 ||
                        grid[x][y] != 1
                    ) continue;

                    grid[x][y] = 2;
                    q.add(new int[] {x, y});
                    --oranges;
                }
            }
        }
        return oranges != 0 ? -1 : time;
    }
}
