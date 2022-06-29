class Solution {
​
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;
        this.heights = heights;
        state = new int[R][C];
        List<List<Integer>> ans = new ArrayList<>();
        
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            dfs(r, 0, 1, visited);            
        }
        for (int c = 0; c < C; c++) {
            dfs(0, c, 1, visited);            
        }
        
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            dfs(r, C - 1, 2, visited);            
        }
        for (int c = 0; c < C; c++) {
            dfs(R - 1, c, 2, visited);            
        }
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (state[r][c] == 3) {
                    ans.add(Arrays.asList(new Integer[] {r, c}));
                }
            }
        }
​
        return ans;
    }
    
    private boolean isValidCell(int r, int c, boolean[][] visited) {
        return 0 <= r && r < visited.length && 0 <= c && c < visited[0].length && !visited[r][c];
    }
    
    private int[][] heights, state;
    
    private int[] dr = {1, 0, -1, 0};
    private int[] dc = {0, 1, 0, -1};
    
    private void dfs(int r, int c, int val, boolean[][] visited) {
        if (!isValidCell(r, c, visited)) {
            return;
        }
        visited[r][c] = true;
        state[r][c] |= val;
        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i], newC = c + dc[i];
            if (isValidCell(newR, newC, visited) && heights[r][c] <= heights[newR][newC]) {
                dfs(newR, newC, val, visited);
            }
        }        
    }
}
