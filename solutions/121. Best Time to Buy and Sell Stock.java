class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxSoFar = prices[n - 1];
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            ans = Math.max(ans, maxSoFar - prices[i]);
            maxSoFar = Math.max(maxSoFar, prices[i]);
        }
        return ans;
    }
}
