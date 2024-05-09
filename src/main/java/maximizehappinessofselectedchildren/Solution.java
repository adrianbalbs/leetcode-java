package maximizehappinessofselectedchildren;

import java.util.Collections;
import java.util.stream.IntStream;

public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int[] sorted = IntStream.of(happiness).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();

        long maxHappiness = 0;
        for (int i = 0; i < k; i++) {
            if (sorted[i] - i >= 0) {
                maxHappiness += sorted[i] - i;
            }
        }
        return maxHappiness;
    }
}
