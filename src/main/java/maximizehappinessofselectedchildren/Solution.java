package maximizehappinessofselectedchildren;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long maxHappiness = 0;
        for (int i = happiness.length - 1; i > happiness.length - 1 - k; i--) {
            maxHappiness += Math.max(happiness[i] - (happiness.length - 1 - i), 0);
        }
        return maxHappiness;
    }
}
