class Solution {
    public int maxScore(int[] nums) {
        N = nums.length;
        arr = nums;
        memo = new int[N + 1][1 << N];
        for (int[] row : memo) Arrays.fill(row, -1);
        return solve(1, 0);
    }
    
    private int gcd(int a, int b) {
        return a == 0? b : gcd(b % a, a);
    }
​
    private int visit(int msk, int idx1, int idx2) {
        return msk | (1 << idx1) | (1 << idx2);
    }
​
    private boolean isVisted(int msk, int idx) {
        return (msk & (1 << idx)) != 0;
    }
​
    int N;
    int[] arr;
    int[][] memo;
​
    private int solve(int idx, int msk) {
        if (idx == N + 1) {
            return 0;
        }
        if (memo[idx][msk] != -1) {
            return memo[idx][msk];
        }
        memo[idx][msk] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisted(msk, i) || isVisted(msk, j)) {
                    continue;
                }
                memo[idx][msk] = Math.max(memo[idx][msk], idx * gcd(arr[i], arr[j]) + solve(idx + 1, visit(msk, i, j)));
            }
        }
        return memo[idx][msk];
    }
}
