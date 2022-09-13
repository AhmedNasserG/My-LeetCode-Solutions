class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a, b) ->{
            return deltaRatio(b[0], b[1]) - deltaRatio(a[0], a[1]) > 0 ? 1 : -1;
             });
        for (int[] c : classes) {
            pq.add(new double[]{c[0],c[1]});
        }
        while (extraStudents-- > 0) {
            double[] top = pq.remove();
            top[0]++; top[1]++;
            pq.add(top);
        }
        double ans = 0;
        while(!pq.isEmpty()) {
            double[] c = pq.remove();
            ans += c[0] / c[1];
        }
        return ans / classes.length;
    }
    
    private double deltaRatio(double pass, double total) {
        return (pass + 1.0) / (total + 1.0) - pass / total;
    }
}
/*
*/
