class Solution {
    private int[] coins;
    private int MAX = (int) 1e5 + 1;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int ans = dp(amount);
        if (ans == MAX) {
            return -1;
        }
        return ans;
    }
    
    private int[] memo;
    private int dp(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return MAX;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }
        int ans = MAX;
        for (int coin : coins) {
            ans = Math.min(ans, 1 + dp(amount - coin));
        }
        return memo[amount] = ans;
    }
}
