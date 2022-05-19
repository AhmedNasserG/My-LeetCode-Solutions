class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = nums[nums.length - 1] - nums[0], ans = 0;;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = getCountOfPairLessThanX(nums, mid);
            if (k <= count) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    private int getCountOfPairLessThanX(int[] nums, int x) {
        // nums is sorted
        int start = 0, end = 1, ans = 0;
        while (end < nums.length) {
            while (nums[end] - nums[start] > x && start < end) {
                start++;
            }
            ans += end - start;
            end++;
        }
        return ans;
    }
}
