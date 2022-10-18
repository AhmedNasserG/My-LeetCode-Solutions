class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char cur = s.charAt(i - 1);
            char prev = s.charAt(i - 2);
            if (cur != '0') {
                dp[i] += dp[i - 1];
            }
            if (prev != '0' && (prev == '1' || prev == '2' && cur <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
​
