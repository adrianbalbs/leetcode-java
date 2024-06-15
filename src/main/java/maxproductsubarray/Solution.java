package maxproductsubarray;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int currMax = 1;
        int currMin = 1;
        int res = nums[0];

        for (int n : nums) {
            int tmp = n * currMax;
            currMax = Math.max(n, Math.max(tmp, n * currMin));
            currMin = Math.min(n, Math.min(tmp, n * currMin));
            res = Math.max(currMax, res);
        }
        return res;
    }
}
