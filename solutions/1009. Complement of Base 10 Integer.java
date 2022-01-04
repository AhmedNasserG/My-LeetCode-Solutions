class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        return ~n & Integer.highestOneBit(n) - 1;
    }
}
​
