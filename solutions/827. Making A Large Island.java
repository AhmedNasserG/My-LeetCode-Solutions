                if (grid[r][c] == 0) {
                    ans = Math.max(ans, merge(grid, r, c));
                }
            }
        }
        if (ans == 0) {
            return R * C;
        } 
        return ans;
    }
    
    private int dfs(int[][] grid, int r, int c, int label) {
        if (!inBound(grid, r, c) || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = label;
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            ans += dfs(grid, r + dr[i], c + dc[i], label);
        }
        return ans;
    }
    
    private boolean inBound(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
​
    private int merge(int[][] grid, int r, int c) {
        Set<Integer> set = new HashSet();
        set.add(0);
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (inBound(grid, newR, newC)) {
                int label = grid[newR][newC];
                if (!set.contains(label)) {
                    ans += map.get(label);
                    set.add(label);
                }
            }
        }
        return ans;
    }
}
​
