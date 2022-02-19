class Solution {
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()][p.length() + 2];
        return isMatch(s, p, 0, 0);
    }
    Boolean[][] memo;
    boolean isMatch(String s, String p, int i, int j) {
        if (i == s.length()) {
            while (j < p.length()) {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    j += 2;
                } else {
                    return false;
                }
            }
            return true;
        }
        if (j == p.length()) {
            return i == s.length();
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            return memo[i][j] = isMatch(s, p, i, j + 2) || match(s.charAt(i), p.charAt(j)) && (isMatch(s, p, i + 1, j) || isMatch(s, p, i + 1, j + 2)) ;
        } else {
            return memo[i][j] = match(s.charAt(i), p.charAt(j)) && isMatch(s, p, i + 1, j + 1);
        }
    }
    
    boolean match(char a, char b) {
        return a == b || a == '.' || b == '.';
    }
}
