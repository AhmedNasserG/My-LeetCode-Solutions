class Solution {
    public int countOrders(int n) {
        long res = 1;
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            res = res * (2 * i - 1) * i % mod;
        }
        return (int)res;
    }
}
