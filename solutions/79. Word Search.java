class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int[] dr = {1, 0, -1, 0};
    private int[] dc = {0, 1, 0, -1};
    
    private boolean dfs(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) return true;
        if (!isValid(board, r, c)) return false;
        if (board[r][c] != word.charAt(idx)) return false;
        char current = board[r][c];
        board[r][c] = '#';
        for (int i = 0; i < 4; i++) {
            if (dfs(board, r + dr[i], c + dc[i], word, idx + 1)) return true;
        }
        board[r][c] = current;
        return false;
    }
    
    private boolean isValid(char[][] board, int r, int c) {
        return 0 <= r && r < board.length && 0 <= c && c < board[0].length && board[r][c] != '#';
    }
}
