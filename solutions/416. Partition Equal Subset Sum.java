class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        memo = new Boolean[nums.length][sum / 2 + 1];
        return dp(nums, 0, sum / 2);
    }
    Boolean[][] memo;
    boolean dp(int[] nums, int i, int sum) {
        if (i == nums.length) {
            return sum == 0;
        }
        if (memo[i][sum] != null) {
            return memo[i][sum];
        }
        memo[i][sum] = false;
        if (sum - nums[i] >= 0) {
            memo[i][sum] |= dp(nums, i + 1, sum - nums[i]);
        }
        memo[i][sum] |= dp(nums, i + 1, sum);
        return memo[i][sum];
    }
}
