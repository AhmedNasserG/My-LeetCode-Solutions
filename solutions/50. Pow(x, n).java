class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1 / x, -(n + 1)) * 1 / x;
            }
            return myPow(1 / x, -n);
        }
        if (n == 1) {
            return x;
        }
        double half = myPow(x, n / 2);
        double rem = n % 2 == 1 ? x : 1;
        return half * half * rem;
    }
    
}
