class Solution {
    public int calculate(String s) {
        List<String> exp = getPostfix(s);
        Stack<Integer> stack = new Stack();
        for (String str : exp) {
            if (Character.isDigit(str.charAt(0))) {
                stack.push(Integer.parseInt(str));
            } else {
                stack.push(eval(str, stack.pop(), stack.pop()));
            }
        }
        return stack.pop();
    }
    
    private List<String> getPostfix(String s) {
        List<String> list = new ArrayList();
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    list.add(stack.pop() + "");
                }
                stack.push(c);
            }
        }
        list.add(sb.toString());
        while (!stack.isEmpty()) {
            list.add(stack.pop() + "");
        }
        return list;
    }
    
    private int getPriority(char c) {
        switch(c) {
            case '+' : case '-': return 1;
            case '*' : case '/' : return 2;
            default : return -1;
        }
    }
    
    private int eval(String str, int num2, int num1) {
        switch (str) {
            case "+" : return num1 + num2; 
            case "-" : return num1 - num2; 
            case "*" : return num1 * num2; 
            case "/" : return num1 / num2; 
            default: return Integer.MIN_VALUE;
        }
    }
}
​
