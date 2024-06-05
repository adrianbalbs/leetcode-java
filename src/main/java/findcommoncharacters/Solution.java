package findcommoncharacters;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] words) {
        int[] commonChars = new int[26];
        for (char c : words[0].toCharArray()) {
            commonChars[c - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] wordCount = new int[26];
            for (char c : words[i].toCharArray()) {
                wordCount[c - 'a']++;
            }
            for (int ch = 0; ch < commonChars.length; ch++) {
                commonChars[ch] = Math.min(commonChars[ch], wordCount[ch]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int ch = 0; ch < commonChars.length; ch++) {
            for (int i = 0; i < commonChars[ch]; i++) {
                res.add(String.valueOf((char) (ch + 'a')));
            }
        }
        return res;
    }
}
