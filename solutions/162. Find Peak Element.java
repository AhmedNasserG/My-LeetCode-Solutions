class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1, ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
​
