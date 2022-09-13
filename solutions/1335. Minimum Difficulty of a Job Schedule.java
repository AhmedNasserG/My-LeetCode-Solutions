class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        jobs = jobDifficulty;
        memo = new int[d + 1][jobs.length][1001];
        for (int[][] a : memo) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        int ans = solve(0, 0, d);
        if (ans >= INF) return -1;
        return ans;
    }
    
    int INF = (int)1e6;
    int[] jobs;
    int[][][] memo;
    
    private int solve(int i, int maxSoFar, int d) {
        if (i == jobs.length) {
            return d == 0 ? maxSoFar : INF;
        }
        if (d < 0) return INF;
        if (memo[d][i][maxSoFar] != -1) {
            return memo[d][i][maxSoFar];
        }
        int take = 0, leave = 0;
        take = solve(i + 1, Math.max(maxSoFar, jobs[i]), d);
        leave = maxSoFar + solve(i + 1, jobs[i], d - 1);
        return memo[d][i][maxSoFar] = Math.min(take, leave);
    }
}
​
