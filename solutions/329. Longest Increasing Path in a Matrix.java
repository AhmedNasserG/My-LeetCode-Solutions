class Solution {
    private int[] dr = {0, 0, 1, -1};
    private int[] dc = {1, -1, 0, 0};
    private int[][] memo;
    
    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        memo = new int[R][C];
        int ans = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (memo[r][c] == 0) {
                    ans = Math.max(ans, dfs(matrix, r, c, -1));
                }
            }
        }
        return ans;    
    }
    
    private int dfs(int[][] matrix, int r, int c, int prev) {
        if (!inBound(matrix, r, c) || matrix[r][c] <= prev) {
            return 0;
        }
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        for (int i = 0; i < 4; i++) {
            memo[r][c] = Math.max(memo[r][c], 1 + dfs(matrix, r + dr[i], c + dc[i], matrix[r][c]));
        }
        return memo[r][c];
    }
    
    private boolean inBound(int[][] matrix, int r, int c) {↔}
}
​
​
