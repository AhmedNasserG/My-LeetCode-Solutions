class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int lastPeek = -1;
        int i = n - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                lastPeek = i - 1;
                break;
            }
            i--;
        }
        if (lastPeek != -1) {
            int j = lastPeek + 1;
            while (j + 1 < n && nums[lastPeek] < nums[j + 1]) {
                j++;
            }
            swap(nums, lastPeek, j);
        }
        reverse(nums, lastPeek + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i) {
        int n = nums.length - 1;
        while (i < n) {
            swap(nums, i++, n--);
        }
    }
}
