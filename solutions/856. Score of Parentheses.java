class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, pow = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            char cur = s.charAt(i), next = s.charAt(i + 1);
            if (cur == '(' && next == ')') {
                ans += pow;
                i++;
            } else if (cur == '(') {
                pow *= 2;
            } else {
                pow /= 2;
            }
        }
        return ans;
    }
}
