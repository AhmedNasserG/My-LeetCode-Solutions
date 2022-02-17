class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            count = nums[i - 1] < nums[i] ? count + 1 : 1;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
