class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int stack = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack++;
            } else if (c == ')') {
                stack--;
            }
            ans = Math.max(ans, stack);
        }
        return ans;
    }
}
