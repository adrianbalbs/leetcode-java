package longestpalindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        boolean isOdd = false;
        int longestPalindrome = 0;
        for (int freq : freqMap.values()) {
            if (freq % 2 == 0) {
                longestPalindrome += freq;
            } else {
                longestPalindrome += freq - 1;
                isOdd = true;
            }
        }
        return isOdd ? longestPalindrome + 1 : longestPalindrome;
    }
}
