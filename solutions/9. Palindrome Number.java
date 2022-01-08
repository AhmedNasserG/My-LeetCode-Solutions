class Solution {
    public boolean isPalindrome(int x) {
        long original = x;
        long reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return reversed == original;
    }
}
