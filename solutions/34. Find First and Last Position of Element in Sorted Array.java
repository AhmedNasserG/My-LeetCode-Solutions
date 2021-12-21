class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {getLeft(nums, target), getRight(nums, target)};
    }
    
    private int getLeft(int[] nums, int target) {
        int start = 0, end = nums.length - 1, ans = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    } 
    
    
    private int getRight(int[] nums, int target) {
        int start = 0, end = nums.length - 1, ans = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    } 
}
