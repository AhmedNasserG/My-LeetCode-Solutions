class Solution {
    class Cell {
        int r, c;
        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int maxDistance(int[][] grid) {
        this.grid = grid;
        Queue<Cell> q = new LinkedList();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    q.add(new Cell(r, c));
                }
            }
        }
        int max = -1;
        while (!q.isEmpty()) {
            Cell cell = q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = cell.r + dr[i], nc = cell.c + dc[i];
                if (isValid(nr, nc)) {
                    grid[nr][nc] = grid[cell.r][cell.c] + 1;
                    q.add(new Cell(nr, nc));
                    max = Math.max(grid[nr][nc] - 1, max);
                }
            }
        } 
        return max;
    }
    private int[] dr = new int[]{1, 0, -1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    private int[][] grid;
    
    private boolean isValid(int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 0;
    }
}
