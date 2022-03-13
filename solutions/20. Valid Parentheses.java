class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =0 ;i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '[' || current == '{' || current == '(') {
                stack.push(current);
            } else {
                if (stack.isEmpty() || opposite(current) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public char opposite(char c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else {
            return '[';
        }
    }
}
