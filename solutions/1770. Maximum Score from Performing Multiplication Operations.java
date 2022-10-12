class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        memo = new HashMap();
        return solve(nums, multipliers, 0, 0, nums.length - 1);
    }
    HashMap<String, Integer> memo;
    private int solve(int[] nums, int[] mult, int idx, int l, int r) {
        if (idx == mult.length) {
            return 0;
        }
        String state = l + "," + r;
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        int left = nums[l] * mult[idx] + solve(nums, mult, idx + 1, l + 1, r);
        int right = nums[r] * mult[idx] + solve(nums, mult, idx + 1, l, r - 1);
        memo.put(state, Math.max(left, right));
        return memo.get(state);
    }
}
