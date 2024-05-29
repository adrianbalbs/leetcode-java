package pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] atl = new boolean[m][n];
        boolean[][] pac = new boolean[m][n];
        for (int r = 0; r < m; ++r) {
            dfs(r, 0, pac, m, n, heights[r][0], heights);
            dfs(r, n - 1, atl, m, n, heights[r][n - 1], heights);
        }

        for (int c = 0; c < n; ++c) {
            dfs(0, c, pac, m, n, heights[0][c], heights);
            dfs(m - 1, c, atl, m, n, heights[m - 1][c], heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (atl[i][j] && pac[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int r, int c, boolean[][] vis, int m, int n, int prevHeight, int[][] heights) {
        if (r < 0 || c < 0 || r >= m || c >= n || heights[r][c] < prevHeight || vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        dfs(r - 1, c, vis, m, n, heights[r][c], heights);
        dfs(r + 1, c, vis, m, n, heights[r][c], heights);
        dfs(r, c - 1, vis, m, n, heights[r][c], heights);
        dfs(r, c + 1, vis, m, n, heights[r][c], heights);
    }
}
