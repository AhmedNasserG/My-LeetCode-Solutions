class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0 && isClosed(grid, r, c)) {
                    count++;
                } 
            }
        }
        return count;
    }
    
    private int[] dr = new int[] {1, 0, -1, 0};
    private int[] dc = new int[] {0, 1, 0, -1};
    
    private boolean isClosed(int[][] grid, int r, int c) {
        if (!inBound(grid, r, c)) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        }
        boolean ans = true;
        grid[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            ans &= isClosed(grid, r + dr[i], c + dc[i]);
        }
        return ans;
    }
    
    private boolean inBound(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
