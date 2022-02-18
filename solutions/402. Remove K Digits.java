class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        for(char d : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > d && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(d);
        }   
        while (!stack.isEmpty() && k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        int i = sb.length() - 1;
        
        while (i > 0) {
            if (sb.charAt(i) == '0') {
                sb.setLength(sb.length() - 1);
            } else {
                break;
            }
            i--;
        }
        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}
