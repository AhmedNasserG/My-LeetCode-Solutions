class Solution {
    public int numEnclaves(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        for (int r = 0; r < R; r++) {
            dfs(grid, r, 0);
            dfs(grid, r, C - 1);
        }
        for (int c = 0; c < C; c++) {
            dfs(grid, 0, c);
            dfs(grid, R - 1, c);
        }
        int ans = 0;
        for (int r = 1; r < R - 1; r++) {
            for (int c = 1; c < C - 1; c++) {
                ans += grid[r][c];
            }
        }
        return ans;
    }
    
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    
    private void dfs(int[][] grid, int r, int c) {
        if (!isValid(grid, r, c)) {
            return;
        }
        grid[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            dfs(grid, r + dr[i], c + dc[i]);
        }
        return;
    }
    
    private boolean isValid(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1;
    }
}
