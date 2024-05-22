package kclosestpointstoorigin;

import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = pq.remove();
            ans[i][0] = cur[0];
            ans[i][1] = cur[1];
        }
        return ans;
    }
}
