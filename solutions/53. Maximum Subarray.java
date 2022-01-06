class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(0, sum);
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
