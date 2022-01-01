class Solution {
    private int[][] memo;
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) return 0;
        memo = new int[s.length()][t.length()];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return helper(0, 0, s, t);
    }
    
    
    private int helper(int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
        }
        
        if (i == s.length()) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int ans = 0;
        // take 
        if (s.charAt(i) == t.charAt(j)) {
            ans += helper(i + 1, j + 1, s, t);
        }
        
        // leave
        ans += helper(i + 1, j, s, t);
        
        return memo[i][j] = ans;
    }
}
