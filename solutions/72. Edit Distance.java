class Solution {
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] a : memo) Arrays.fill(a, -1);
        return dp(word1, word2, 0, 0);
    }
    int[][] memo;
    int dp(String s1, String s2, int i, int j) {
        if (i == s1.length()) {
            return s2.length() - j;
        }
        if (j == s2.length()) {
            return s1.length() - i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = dp(s1, s2, i + 1, j + 1);
        }
        
        int insert = 1 + dp(s1, s2, i, j + 1);
        int delete = 1 + dp(s1, s2, i + 1, j);
        int replace = 1 + dp(s1, s2, i + 1, j + 1);
        return memo[i][j] = Math.min(Math.min(insert, delete), replace);
    }
}
