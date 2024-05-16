package combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, sums, curr, target, 0);
        return sums;
    }

    void dfs(int[] candidates, List<List<Integer>> sums, List<Integer> curr, int target, int index) {
        if (target == 0) {
            sums.add(new ArrayList<>(curr));
            return;
        } else if (target < 0 || index >= candidates.length) {
            return;
        }
        curr.add(candidates[index]);
        dfs(candidates, sums, curr, target - candidates[index], index + 1);
        curr.remove(curr.size() - 1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) index++;
        dfs(candidates, sums, curr, target, index + 1);
    }
}
