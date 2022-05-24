class Solution {
    public void nextPermutation(int[] nums) {
        int a = -1, b = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                a = i;
                b = i + 1;
            }
        }
        if (a == -1){ 
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = b; i < nums.length; i++) {
            if (nums[i] > nums[a]) {
                b = i;
            }
        }
        swap(nums, a, b);
        reverse(nums, a + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
