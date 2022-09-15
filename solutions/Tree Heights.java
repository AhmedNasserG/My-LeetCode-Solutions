class Solution {

  public static int solve(int[] nums) {
    int n = nums.length;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    } 
    max = Math.max(max - min, n); 
    for (int i = 0; i < n; i++) {
      nums[i] -= min;
    }

    int[][] dp = new int[nums.length][max + 1];
    for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

    for (int j = 0; j <= max; j++) {
      dp[0][j] = Math.abs(nums[0] - j);
    }

    for (int i = 1; i < n; i++) {
      int minSoFar = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        minSoFar = Math.min(minSoFar, dp[i - 1][j]);
      }
      for (int j = i; j <= max; j++) {
        dp[i][j] = Math.abs(nums[i] - j) + minSoFar;
        minSoFar= Math.min(minSoFar, dp[i - 1][j]);
      }
    }

    int ans = Integer.MAX_VALUE;
    for (int j = 0; j <= max; j++) {
      ans = Math.min(ans, dp[n - 1][j]);
    }

    return ans;
  }
