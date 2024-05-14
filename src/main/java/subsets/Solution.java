package subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        dfs(res, subsets, nums, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> subsets, int[] nums, int index) {
        if (index > nums.length) {
            res.add(new ArrayList<>(subsets));
            return;
        }
        subsets.add(nums[index]);
        dfs(res, subsets, nums, index + 1);
        subsets.remove(subsets.size() - 1);
        dfs(res, subsets, nums, index + 1);
    }
}
