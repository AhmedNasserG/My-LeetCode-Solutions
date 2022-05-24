import java.util.*;

public class Solution {

    public int calculate(String s) {
        List<String> infix = parse(s);
        List<String> postfix = getPostfix(infix);
        return evaluate(postfix);
    }
    
    public List<String> parse(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
                if (isSign(c)) {
                    res.add(c + "");
                }
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString());
        }
        return res;
    }
    
    public List<String> getPostfix(List<String> infix) {
        List<String> res = new ArrayList<>();
        Stack<String> s = new Stack<>();
        
        for (String element : infix) {
            if (Character.isDigit(element.charAt(0))) {
                res.add(element);
            } else {
                if (element.equals("(")) {
                    s.push(element);
                } else if (element.equals(")")) {
                    while (!s.peek().equals("(")) {
                        res.add(s.pop());
                    }
                    s.pop();
                } else {
                    while (!s.isEmpty() && !s.peek().equals("(") && getPriority(element) <= getPriority(s.peek())) {
                        res.add(s.pop());
                    }
                    s.push(element);
                }
            }
        }
        
        while (!s.isEmpty()) {
            res.add(s.pop());
        }
        
        return res;
    }
    
    public int evaluate(List<String> postfix) {
        Stack<Long> s = new Stack<>();
        for (String element : postfix) {
            if (Character.isDigit(element.charAt(0))) {
                s.push(Long.parseLong(element));
            } else {
                s.push(calc(s.pop(), s.pop(), element));
            }
        }
        return s.pop().intValue();
    }
    
    public boolean isSign(char c) {
        return c == '(' || c == ')' || c == '+' || c == '-' || c == '/' || c == '*';
    }
    
    public int getPriority(String c) {
        switch (c) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
        }
        return -1;
    }
    
    public long calc(long second, long first, String op) {
        switch(op) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second;
        }
        return -1;
    }
}
