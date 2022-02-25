class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        isVisited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    int[] dr = new int[]{1, 0, -1, 0};
    int[] dc = new int[]{0, 1, 0, -1};
    boolean[][] isVisited;
    
    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (!isValid(image, r, c, oldColor)) {
            return;
        }
        image[r][c] = newColor;
        isVisited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            dfs(image, r + dr[i], c + dc[i], oldColor, newColor);
        }
    }
    
    private boolean isValid(int[][] image, int r, int c, int oldColor) {
        return 0 <= r && r < image.length && 0 <= c && c < image[0].length && image[r][c] == oldColor && !isVisited[r][c];
    }
}
