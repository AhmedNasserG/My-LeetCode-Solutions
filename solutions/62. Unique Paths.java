class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(0, 0, memo);
    }
    
    private int dfs(int r, int c, int[][] memo) {
        if (!inBounds(r, c, memo)) return 0;
        if (r == memo.length - 1 && c == memo[0].length - 1) return 1;
        if (memo[r][c] != -1) return memo[r][c];
        memo[r][c] = 0;
        memo[r][c] += dfs(r + 1, c, memo);
        memo[r][c] += dfs(r, c + 1, memo);
        return memo[r][c];
    }
    
    private boolean inBounds(int r, int c, int[][] arr) {
        return 0 <= r && r < arr.length && 0 <= c && c < arr[0].length;
    }
}
