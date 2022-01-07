class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int right = getfisrtNN(nums);
        int left = right - 1;
        for (int i = 0; i < nums.length; i++) {
            if (right < nums.length && left >= 0) {
                if (nums[right] < -nums[left]) {
                    ans[i] = nums[right] * nums[right];
                    right++;
                } else {
                    ans[i] = nums[left] * nums[left];
                    left--;
                }
            } else {
                if (right < nums.length) {
                    ans[i] = nums[right] * nums[right];
                    right++;
                } else {
                    ans[i] = nums[left] * nums[left];
                    left--;
                }
            }
        }
        return ans;
    }
    
    private int getfisrtNN(int[] nums) {
        int start = 0, end = nums.length - 1, ans = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
