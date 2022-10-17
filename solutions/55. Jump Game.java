class Solution {
    public boolean canJump(int[] nums) {
        int maxJumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && maxJumps <= 1) return false;
            maxJumps = Math.max(maxJumps - 1, nums[i]);
        }
        return true;
    }
}
