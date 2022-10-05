class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int n = nums.length;
      Arrays.sort(nums);
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i < n - 2; i++) {
          int start = i + 1, end = n - 1;
          while (start < end) {
              int sum = nums[i] + nums[start] + nums[end];
              if (Math.abs(target - sum) < Math.abs(target - ans)) {
                  ans = sum;
              }
              if (target > sum) {
                  start++;
              } else {
                  end--;
              }
          }
      }
      return ans;
  }
}
