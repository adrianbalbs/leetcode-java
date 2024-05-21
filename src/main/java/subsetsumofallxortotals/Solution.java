package subsetsumofallxortotals;

public class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    int backtrack(int[] nums, int index, int currXor) {
        if (index == nums.length) {
            return currXor;
        }
        int withNum = backtrack(nums, index + 1, currXor ^ nums[index]);
        int withoutNum = backtrack(nums, index + 1, currXor);
        return withNum + withoutNum;
    }
}
