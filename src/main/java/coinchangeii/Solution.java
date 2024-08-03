package coinchangeii;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // There is only 1 way to make up an amount of 0, with no coins at all
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }
}
