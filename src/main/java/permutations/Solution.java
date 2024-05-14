package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(permutations, curr, nums, new HashSet<>());
        return permutations;
    }

    void dfs(List<List<Integer>> permutations, List<Integer> curr, int[] nums, Set<Integer> used) {
        if (curr.size() == nums.length) {
            permutations.add(new ArrayList<>(curr));
        }
        for (int num : nums) {
            if (!used.contains(num)) {
                curr.add(num);
                used.add(num);
                dfs(permutations, curr, nums, used);
                curr.remove(curr.size() - 1);
                used.remove(num);
            }
        }
    }

}
