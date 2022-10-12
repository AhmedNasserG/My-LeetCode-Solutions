class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        memo = new int[1 << (2 * numSlots)];
        Arrays.fill(memo, -1);
        return dp(nums, 0, numSlots, 0);
    }
    
    static int[] memo;
    static int dp(int[] nums, int idx, int numOfSlots, int msk) {
        if (idx == nums.length) {
            return 0;
        }
        if (memo[msk] != -1) {
            return memo[msk];
        }
        int ans = 0;
        for (int i = 0; i < 2 * numOfSlots; i++) {
            if ((msk & (1 << i)) == 0) {
                ans = Math.max(ans, (nums[idx] & (i / 2 + 1)) + dp(nums, idx + 1, numOfSlots, msk | (1 << i)));
            }
        }
        return memo[msk] = ans;
    }
}
