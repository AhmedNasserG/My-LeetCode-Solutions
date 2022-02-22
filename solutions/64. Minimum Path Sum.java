class Solution {
    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        for (int[] a : memo) Arrays.fill(a, -1);
        return dp(0, 0, grid);
    }
    int INF = 100000;
    int[][] memo;
    int dp(int r, int c, int[][] grid) {
        if (r >= grid.length || c >= grid[0].length) {
            return INF;
        }
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }
        if (memo[r][c] != -1) {
            return memo[r][c];
        }
        return memo[r][c] = grid[r][c] + Math.min(dp(r + 1, c, grid), dp(r, c + 1, grid));
    }
}
