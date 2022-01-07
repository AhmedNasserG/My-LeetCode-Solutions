class Solution {
    public int minAddToMakeValid(String s) {
        int stack = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c =='(') {
                stack++;
            } else {
                stack--;
            }
            if (stack < 0) {
                ans++;
                stack = 0;
            }
        }
        return ans + stack;
    }
}
