class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, dfs(grid, r, c));
            }
        }
        return ans;
    }
    
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    private int dfs(int[][] grid, int r, int c) {
        if (!isValid(grid, r, c)) return 0;
        grid[r][c] = 0;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            area += dfs(grid, r + dr[i], c + dc[i]);
        }
        return area;
    }
    private boolean isValid(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1;
    }
}
