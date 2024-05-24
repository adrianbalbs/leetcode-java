package palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    void dfs(List<List<String>> res, List<String> curr, String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                curr.add(s.substring(i, j + 1));
                dfs(res, curr, s, j + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}