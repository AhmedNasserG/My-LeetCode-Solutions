class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList();
        HashSet<String> set = new HashSet();
        for (String word : words) {
            set.add(word);
        }
        
        for (String word : words) {
            memo = new Boolean[word.length()][word.length()];
            if (solve(word, set, 0, 0, new StringBuilder())) {
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    Boolean[][] memo;
    
    boolean solve(String s, HashSet<String> set, int start, int end, StringBuilder sb) {
        if (end == s.length()) {
            return !sb.toString().equals(s) && set.contains(sb.toString());
        }
        
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        
        boolean ans = false;
        
        // continue
        sb.append(s.charAt(end));
        ans |= solve(s, set, start, end + 1, sb);
        sb.setLength(sb.length() - 1);
        
        // split
        if (set.contains(sb.toString()) ) {
            ans |= solve(s, set, end, end, new StringBuilder());
        }
        
        return memo[start][end] = ans;
    }
}
