package besttimetobuyandsellstockwithcooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        /**
         * 1 = holding on to stock
         * Recurrence: dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1])
         * dp[i][0] = max(dp[i - 2][0], dp[i - 1][1] + prices[i - 1]
         */
        return 0;
     }
}
