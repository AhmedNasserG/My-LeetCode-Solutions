class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for (int row = 0; row < matrix.length; row++) {
            pq.add(new int[]{row, 0});
        }
        while (--k > 0) {
            int[] cur = pq.remove();
            if (cur[1] < matrix.length - 1) {
                cur[1]++;
                pq.add(cur);
            }
        }
        return matrix[pq.peek()[0]][pq.peek()[1]];
    }
}
