package uniquepaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] opt = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            opt[i][1] = 1;
        }
        for (int j = 0; j < n + 1; j++) {
            opt[1][j] = 1;
        }

        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                opt[i][j] = opt[i - 1][j] + opt[i][j - 1];
            }
        }

        return opt[m][n];
    }
}
