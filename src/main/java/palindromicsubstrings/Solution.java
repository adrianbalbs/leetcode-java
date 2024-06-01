package palindromicsubstrings;

public class Solution {
    public int countSubstrings(String s) {
        // Base Cases i = j is a palindrome
        // if S[i] = S[i + 1], we have a palindrome
        int len = s.length();
        int count = 0;
        boolean[][] isPali = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j || (j == i + 1 && s.charAt(i) == s.charAt(j)) || (s.charAt(i) == s.charAt(j) && isPali[i + 1][j - 1])) {
                    isPali[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countSubstrings("babab"));
    }
}
