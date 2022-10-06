class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int k = 1; k < Math.sqrt(2 * n); k++) {
            if ((n - k * (k + 1) / 2) % k == 0) ans++;
        }
        return ans;
    }
}
​
/*
N = kx + k(k+1)/2 k >= 1
kx = N - k(k+1)/2
2 * N > k(k+1)
*/
