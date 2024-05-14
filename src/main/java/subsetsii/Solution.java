package subsetsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, subsets, curr, 0);
        return subsets;
    }

    void dfs(int[] nums, List<List<Integer>> subsets, List<Integer> curr, int index) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        dfs(nums, subsets, curr, index + 1);
        curr.remove(curr.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(nums, subsets, curr, index + 1);
    }
}
