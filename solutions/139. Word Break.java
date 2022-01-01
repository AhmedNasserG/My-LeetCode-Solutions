class Solution {
    private HashSet<String> set;
    private Boolean[][] memo;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        memo = new Boolean[s.length()][s.length()];
        return helper(0, 0, new StringBuilder(), s);
    }
    
    private boolean helper(int start, int end, StringBuilder sb, String s) {
        if (end == s.length()) {
            return sb.length() == 0;
        } 
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        memo[start][end] = false;
        sb.append(s.charAt(end));
        if (set.contains(sb.toString())) {
            memo[start][end] = helper(end + 1, end + 1, new StringBuilder(), s);
        }
        memo[start][end] = memo[start][end] || helper(start, end + 1, sb, s);
        return memo[start][end];
    }
    
}
