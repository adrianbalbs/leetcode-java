package palindromicsubstrings;

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] isPali = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPali[i][i] = true;
            count++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPali[i][i + 1] = true;
                count++;
            }
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < gap - i; i++) {
                int j = gap + i;
                if (s.charAt(i) == s.charAt(j) && isPali[i + 1][j - 1]) {
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
