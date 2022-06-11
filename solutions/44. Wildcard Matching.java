class Solution {
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length()];
        return dp(s, 0, p, 0);
    }
    
    private Boolean[][] memo;
    private boolean dp(String str, int i, String pattern, int j) {
        if (i == str.length() && j == pattern.length()) {
            return true;
        } else if (j == pattern.length()) {
            return false;
        }
        if (memo[i][j] != null) return memo[i][j];
        if (i < str.length() && (pattern.charAt(j) == '?' || str.charAt(i) == pattern.charAt(j))) {
            return memo[i][j] = dp(str, i + 1, pattern, j + 1);
        } else if (i < str.length() && pattern.charAt(j) == '*') {
            return memo[i][j] = dp(str, i + 1, pattern, j + 1) || dp(str, i + 1, pattern, j) || dp(str, i, pattern, j + 1);
        } else if (i >= str.length() && pattern.charAt(j) == '*') {
            return memo[i][j] = dp(str, i, pattern, j + 1);
        } else {
            memo[i][j] = false;
        }
        return memo[i][j];
    }
}
