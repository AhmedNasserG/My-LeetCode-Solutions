class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack();
        for (int val : asteroids) {
            if (val < 0) {
                while(!s.isEmpty() && s.peek() < -val && s.peek() > 0) {
                    s.pop();
                }
                if (!s.isEmpty() && s.peek() == -val) {
                    s.pop();
                } else if (s.isEmpty() || s.peek() < 0) {
                    s.push(val);
                }
            } else {
                s.push(val);
            }
        }
        int[] ans = new int[s.size()];
        int i = s.size() - 1;
        while (!s.isEmpty()) {
            ans[i--] = s.pop();
        }
        return ans;
    }
}
