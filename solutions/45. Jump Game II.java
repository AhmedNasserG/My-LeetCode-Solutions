class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int l = 0, r = 0;
        while (r < nums.length - 1) {
            int max = 0;
            for (int i = l; i <= r; i++) max = Math.max(max, i + nums[i]);
            l = r + 1;
            r = max;
            ans++;
        }
        return ans;
    }
}
