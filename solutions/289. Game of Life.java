class Solution {
    public void gameOfLife(int[][] board) {
        int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dc = {0, 1, 0, -1, -1, 1, 1, -1};
        int R = board.length, C = board[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int neighbors = 0;
                for (int i = 0; i < dr.length; i++) {
                    int newR = r + dr[i], newC = c + dc[i];
                    if (!inBounds(board, newR, newC)) continue;
                    neighbors += get(board[newR][newC], 0);
                }
                if (neighbors == 3 || neighbors == 2 && get(board[r][c], 0) == 1) {
                    board[r][c] = set(board[r][c], 1);
                }
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                board[r][c] >>= 1;
            }
        }
    }
    
    private int set(int msk, int i) {
        return msk | (1 << i);
    }
    
    private int get(int msk, int i) {
        return (msk & (1 << i)) != 0 ? 1 : 0;
    }
    
    private boolean inBounds(int[][] board, int r, int c) {
        return 0 <= r && r < board.length && 0 <= c && c < board[0].length;
    }
}
