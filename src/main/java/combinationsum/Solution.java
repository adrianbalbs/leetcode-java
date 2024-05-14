package combinationsum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        dfs(candidates, res, nums, target, 0, 0);
        return res;
    }

    void dfs(int[] candidates, List<List<Integer>> res, List<Integer> nums, int target, int i, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(nums));
            return;
        } else if (sum > target || i >= candidates.length) {
            return;
        }

        nums.add(candidates[i]);
        dfs(candidates, res, nums, target, i, sum + candidates[i]);
        nums.remove(nums.size() - 1);
        dfs(candidates, res, nums, target, i + 1, sum);
    }
}
