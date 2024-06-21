package magneticforcebetweentwoballs;

import java.util.Arrays;

public class Solution {
    private boolean canPlace(int[] position, int m, int dist) {
        int prevPos = position[0];
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - prevPos >= dist) {
                prevPos = position[i];
                m--;
            }
            if (m == 0) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0;
        int r = position[position.length - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canPlace(position, m, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
