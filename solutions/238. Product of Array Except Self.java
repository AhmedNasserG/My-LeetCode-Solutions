class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = nums[i] * ans[i + 1];
        }
        int preAns = 1;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = preAns * ans[i + 1];
            preAns *= nums[i];
        }
        ans[n - 1] = preAns;
        return ans;
    }
}
