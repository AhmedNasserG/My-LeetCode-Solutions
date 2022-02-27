class Solution {
    private int[][] grid1, grid2;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        int count = 0;
        for (int r = 0; r < grid2.length; r++) {
            for (int c = 0; c < grid2[0].length; c++) {
                if (grid2[r][c] == 1 && dfs(r, c)) count++;
            }
        }
        return count;
    }
    
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    
    private boolean dfs(int r, int c) {
        if (!isValid(r, c)) {
            return true;
        }
        boolean ans = grid1[r][c] == 1;
        grid2[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            ans &= dfs(r + dr[i], c + dc[i]);
        }
        return ans;
    }
    
    private boolean isValid(int r, int c) {
        return 0 <= r && r < grid2.length && 0 <= c && c < grid2[0].length && grid2[r][c] == 1; 
    }
}
