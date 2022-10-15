class Solution {
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<int[]> q = new LinkedList();
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[] {r, c});
                    grid[r][c] = 0;
                }
            }
        }
        
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int ans = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                int r = q.peek()[0], c = q.peek()[1]; q.remove();
                for (int[] move : moves) {
                    int newR = r + move[0], newC = c + move[1];
                    if (isValidCell(newR, newC, grid)) {
                        grid[newR][newC] = 0;
                        q.add(new int[] {newR, newC});
                    }
                }
            }
            ans++;
        }
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }
        
        
        return Math.max(ans - 1, 0);
    }
    
    boolean isValidCell(int r, int c, int[][] grid) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1;
    }
}
