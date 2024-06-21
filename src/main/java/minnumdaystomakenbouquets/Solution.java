package minnumdaystomakenbouquets;

import java.util.Arrays;

public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 0;
        int r = Arrays.stream(bloomDay).max().orElseThrow();
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canMakeBouquet(bloomDay, m, k, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return res;
    }

    private boolean canMakeBouquet(int[] bloomDay, int m, int k, int d) {
        int count = 0;
        for (int i : bloomDay) {
            if (i <= d) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                m--;
                count = 0;
            }
            if (m == 0) return true;
        }
        return false;
    }
}
