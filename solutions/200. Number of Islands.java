class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i =0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    private void dfs(char[][] grid, int r, int c) {
        if (!isValid(grid, r, c)) {
            return;
        }
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, r + dr[i], c + dc[i]);
        }
    }
    private boolean isValid(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] != '0';
    }
}
