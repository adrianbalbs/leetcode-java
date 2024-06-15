package partitionequalsubsetsum;

import java.util.Arrays;

public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        if (sum % 2 != 0) return false;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // We cannot partition an empty array for 0 <= j <= sum
        for (int j = 0; j <= target; j++) {
            dp[0][j] = false;
        }

        // Must be a case where we have been able to find a valid partition
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // This part here is very similar to 0-1 knapsack, where the sum / 2 is our weight
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
