class Solution {
    public int climbStairs(int n) {
        int prev = 1, prevprev = 0;
        while (n-- > 0) {
            int cur = prev + prevprev;
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
    
}
