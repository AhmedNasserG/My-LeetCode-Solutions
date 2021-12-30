class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int ans = 0, n = 0;
        while (ans <= k) {
            n = (n * 10 + 1) % k;
            ans++;
            if (n == 0) {
                return ans;
            }
        }
        return -1;
    }
}
