class Solution {
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, 1, -1};
    private char[][] board;
    private int R, C;
    
    public void solve(char[][] board) {
        this.board = board;
        R = board.length;
        C = board[0].length;
        
        for (int r = 0; r < R; r++) {
            dfs(r, 0);
            dfs(r, C - 1);
        }
        
        for (int c = 0; c < C; c++) {
            dfs(0, c);
            dfs(R - 1, c);
        }
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '*') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    
    private void dfs(int r, int c) {
        if (!isValid(r, c)) {
            return;
        }
        board[r][c] = '*';
        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i]);
        }
    }
    
    private boolean isValid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C && board[r][c] == 'O';
    }
}
