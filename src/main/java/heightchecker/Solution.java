package heightchecker;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int[] orderedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(orderedHeights);

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != orderedHeights[i]) res++;
        }
        return res;
    }
}
