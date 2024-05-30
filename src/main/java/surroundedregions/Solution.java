package surroundedregions;

public class Solution {
    public int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public void solve(char[][] board) {
        // Traverse the borders and dfs whenever we see an "O", fill the "O" with "V"
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; ++r) {
            dfs(board, r, 0, rows, cols);
            dfs(board, r, cols - 1, rows, cols);
        }

        for (int c = 0; c < cols; ++c) {
            dfs(board, 0, c, rows, cols);
            dfs(board, rows - 1, c, rows, cols);
        }

        // Fill the board by replacing the V's with O's, and replacing everything else with 'X'
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (board[r][c] == 'V') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'V';
        for (int[] d : directions) {
            dfs(board, r + d[0], c + d[1], rows, cols);
        }
    }
}
