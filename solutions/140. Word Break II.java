class Solution {
    private HashSet<String> set;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        List<String> ans = new ArrayList<>();
        helper(0, 0, new StringBuilder(), s, ans);
        return ans;
    }
    
    private void helper(int start, int end, StringBuilder sb, String s, List<String> ans) {
        if (end == s.length()) {
            if (start == s.length()) {
                sb.setLength(sb.length() - 1);
                ans.add(sb.toString());
                sb.append(" ");
            }
            return;
        } 
        String sub = s.substring(start, end + 1);
        if (set.contains(sub)) {
            sb.append(sub).append(" ");
            helper(end + 1, end + 1, sb, s, ans);
            sb.setLength(sb.length() - 1 - sub.length());
        }
        helper(start, end + 1, sb, s, ans);
    }
    
}
