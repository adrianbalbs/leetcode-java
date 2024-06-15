package minimumwindowsubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);

        }

        int have = 0;
        int need = tCount.size();
        int resStart =  -1;
        int resEnd = -1;
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
               char c = s.charAt(r);
               sCount.put(c, sCount.getOrDefault(c, 0) + 1);
               if (tCount.containsKey(c) && sCount.get(c) == tCount.get(c)) {
                   have++;
               }

               while (have == need) {
                   if (r - l + 1 < resLen) {
                       resStart = l;
                       resEnd = r;
                       resLen = r - l + 1;
                   }
                   char del = s.charAt(l++);
                   sCount.put(del, sCount.get(del) - 1);
                   if (tCount.containsKey(del) && sCount.get(del) < tCount.get(del)) {
                       have--;
                   }
               }
        }

        return resLen != Integer.MAX_VALUE ? s.substring(resStart, resEnd + 1) : "";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("aa", "aa"));
    }

}
