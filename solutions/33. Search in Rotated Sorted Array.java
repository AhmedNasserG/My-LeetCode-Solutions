class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            int comp;
            if ((nums[0] <= nums[mid]) == (nums[0] <= target)) { // check if mid and target on the same part
                comp = nums[mid];
            } else {
                comp = nums[0] <= nums[mid] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            if (comp == target) {
                return mid;
            } else if (comp > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
