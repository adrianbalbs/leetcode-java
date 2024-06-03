package appendcharactersinastringtomakesubsequence;

public class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (j == n) return 0;
            if (s.charAt(i) == t.charAt(j)) j++;
        }
        return n - j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.appendCharacters("coaching", "coding"));
        System.out.println(solution.appendCharacters("abcde", "a"));
        System.out.println(solution.appendCharacters("z", "abcde"));
    }
}
