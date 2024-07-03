package numberofprovinces;

public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] v = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                dfs(v, i, isConnected);
                count++;
            }
        }
        return count;
    }

    private void dfs(boolean[] v, int i, int[][] isConnected) {
        if (v[i]) return;
        v[i] = true;
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1) dfs(v, j, isConnected);
        }
    }
}

