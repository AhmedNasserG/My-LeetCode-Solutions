class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) sum += num;
        if (sum % k != 0 || nums.length < k) return false;
        Arrays.sort(nums);
        this.nums = nums;
        return backtrack(nums.length - 1, k, 0, 0, sum / k);
    }
    
    private int[] nums;
    private boolean backtrack(int idx, int k, int msk, int sum, int target) {
        if (k == 0) {
            return true;
        } 
        if (sum == target) {
            return backtrack(nums.length - 1, k - 1, msk, 0, target);
        }
        for (int i = idx; i >= 0; i--) {
            if ((msk & (1 << i)) != 0 || sum + nums[i] > target) {
                continue;
            }
            if (backtrack(i - 1, k, msk | (1 << i), sum + nums[i], target)) {
                return true;
            }
        }
        return false;
    }
}
