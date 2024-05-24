package nqueens;

import java.util.*;

public class Solution {
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> posDiag = new HashSet<>();
    private Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(boards, board, 0);
        return boards;
    }
    void dfs(List<List<String>> boards, char[][] board, int row) {
        if (row == board.length) {
            boards.add(create_board(board));
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (this.cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) {
                continue;
            }
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);
            board[row][col] = 'Q';
            dfs(boards, board, row + 1);

            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
            board[row][col] = '.';
        }
    }

    List<String> create_board(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            StringBuilder s = new StringBuilder();
            for (char c : chars) {
                s.append(c);
            }
            res.add(s.toString());
        }
        return res;
    }
}
