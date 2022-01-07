class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int ans = 0;
        int start = 0, end = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                while (start <= end && zeros == k) {
                    if (nums[start] == 0) {
                        zeros--;
                    }
                    start++;
                }
                zeros++;
            }
            end++;
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}
​
