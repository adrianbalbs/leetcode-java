package cheapestflightwithinkstops;

import java.util.Arrays;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int time = k + 1;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < time; ++i) {
            int[] tempDist = dist.clone();
            for (int[] edge : flights) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE) {
                    tempDist[v] = Math.min(tempDist[v], dist[u] + w);
                }
            }
            dist = tempDist;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
