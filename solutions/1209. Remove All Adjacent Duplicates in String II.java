class Solution {
    private class Wrapper {
        char val;
        int count;
        Wrapper(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Wrapper> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast().val == c) {
                deque.peekLast().count++;
            } else {
                deque.addLast(new Wrapper(c, 1));
            }
            
            if (!deque.isEmpty() && deque.peekLast().count == k) {
                deque.removeLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int count = deque.peekFirst().count;
            char val = deque.removeFirst().val;
            while (count-- > 0) {
                sb.append(val);
            }
        }
        return sb.toString();
    }
}
​
