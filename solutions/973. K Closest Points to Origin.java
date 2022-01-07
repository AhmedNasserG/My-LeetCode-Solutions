class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((b, a) -> (a[0] * a[0] + a[1]* a[1]) - (b[0] * b[0] + b[1]* b[1]));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.remove();
        }
        return ans;
    }
}
