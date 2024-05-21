package wordsearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && findWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean findWord(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || word.charAt(index) != board[i][j] || board[i][j] == '#') {
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '#';
        boolean res = findWord(board, word, i - 1, j, index + 1) ||
                findWord(board, word, i + 1, j, index + 1) ||
                findWord(board, word, i, j - 1, index + 1) ||
                findWord(board, word, i, j + 1, index + 1);

        board[i][j] = ch;
        return res;
    }
}
