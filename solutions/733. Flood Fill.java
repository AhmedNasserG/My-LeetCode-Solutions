class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    void fill(int[][] image, int r, int c, int newColor, int oldColor) {
        if (!isValid(image, r, c, oldColor)) {
            return;
        }
        image[r][c] = newColor;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            fill(image, r + dr[i], c + dc[i], newColor, oldColor);
        }
    }
    
    boolean isValid(int[][] image, int r, int c, int oldColor) {
        return 0 <= r && r < image.length && 0 <= c && c < image[0].length && image[r][c] == oldColor && !visited[r][c];
    }
}
