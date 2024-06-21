package heightchecker;

import java.util.Arrays;

class Solution {
    public int[] countingSort(int[] array) {
        int max = Arrays.stream(array).max().orElseThrow(IllegalStateException::new);
        int[] count = new int[max + 1];

        for (int i : array) {
            count[i]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sorted = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sorted[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
        return sorted;
    }

    public int heightChecker(int[] heights) {
        int[] orderedHeights = countingSort(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != orderedHeights[i]) res++;
        }
        return res;
    }
}