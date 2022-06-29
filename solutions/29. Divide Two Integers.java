class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        if (lDividend == 0) return 0;
        long lAns = lDivide(lDividend, lDivisor);
        if (lAns > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return (int) (sign * lAns);
        }
        
    }
    
    private long lDivide(long a, long b) {
        if (b > a) {
            return 0;
        }
        long sum = b;
        long mult = 1;
        while (sum + sum <= a) {
            sum += sum;
            mult += mult;
        }
        return mult + lDivide(a - sum, b);
    }
}
​
