package permutationinstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusionOther(String s1, String s2) {
        Map<Character, Integer> s1Count = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }
        int have = s1Count.size();
        int l = 0, need = 0;
        Map<Character, Integer> s2Count = new HashMap<>();
        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            if (s1Count.containsKey(c)) {
                s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
                if (s1Count.get(c).equals(s2Count.get(c))) need++;
            }

            if (r >= s1.length()) {
                char toRemove = s2.charAt(r - s1.length());
                if (s1Count.containsKey(toRemove)) {
                    if (s2Count.get(toRemove).equals(s1Count.get(toRemove))) need--;
                    s2Count.put(toRemove, s2Count.get(toRemove) - 1);
                }
            }

            if (need == have) return true;
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(freq, freq2))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("abc", "bbbca"));
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
}
