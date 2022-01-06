class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= target) {
                ans = Math.min(ans, end - start);
                sum -= nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
