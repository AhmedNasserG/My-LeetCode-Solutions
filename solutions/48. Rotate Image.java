class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int level = 0; level < n / 2; level++) {
            rotateLevel(matrix, level);
        }
    }
    
    private void rotateLevel(int[][] arr, int level) {
        int n = arr.length;
        for (int i = level; i < n - 1 - level; i++) {
            int temp = arr[n - 1 - i][level]; 
            arr[n - 1 - i][level] = arr[n - 1 - level][n - 1 - i]; 
            arr[n - 1 - level][n - 1 - i] = arr[i][n - 1 - level]; 
            arr[i][n - 1 - level] = arr[level][i]; 
            arr[level][i] = temp;
        }
    }
}
