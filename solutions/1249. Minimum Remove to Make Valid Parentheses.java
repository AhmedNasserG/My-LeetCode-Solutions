class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    arr[i] = '*';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '*';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
