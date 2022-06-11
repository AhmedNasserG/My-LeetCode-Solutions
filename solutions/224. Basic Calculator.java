class Solution {
    private int idx;
    
    public int calculate(String s) {
        idx = 0;
        return evaluate("(" + s + ")");
    }
    
    private int evaluate(String expression) {
        int sign = 1;
        int num = 0;
        int ans = 0;
        while (idx < expression.length()) {
            char c = expression.charAt(idx);
            if (c == ' ') {
                idx++;
                continue;
            } else if (c == '(') {
                idx++;
                ans += sign * evaluate(expression);
            } else if (c == ')') {
                return ans + num * sign;
            } else if (c == '+') {
                ans += num * sign;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                ans += num * sign;
                sign = -1;
                num = 0;
            } else {
                num = num * 10 + (c - '0');
            }
            idx++;
        }
        return ans;
    }
}
