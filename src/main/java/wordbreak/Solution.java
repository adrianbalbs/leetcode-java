package wordbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] valid = new boolean[n + 1];
        valid[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (wordSet.contains(s.substring(j + 1, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return true;
    }
}
