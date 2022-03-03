class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i = 0, val = 1;
        if (n % 2 == 1) ans[i++] = 0;
        while (i < n) {
            ans[i++] = val;
            ans[i++] = -val;
            val++;
        }
        return ans;
    }
}
