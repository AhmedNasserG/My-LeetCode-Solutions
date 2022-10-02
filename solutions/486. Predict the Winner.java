class Solution {
    public boolean PredictTheWinner(int[] nums) {
        memo = new int[2][nums.length][nums.length];
        for (int[][] mat : memo) for (int[] row : mat) Arrays.fill(row, -1);
        int sum = 0;
        for (int val : nums) sum += val;
        int playerOneScore = getPlayerOneScore(nums, 0, nums.length - 1, 1);
        return playerOneScore >= sum - playerOneScore;
    }
    int[][][] memo;
    private int getPlayerOneScore(int[] nums, int start, int end, int turn) {
        if (start > end) {
            return 0;
        }
        if (memo[turn][start][end] != -1) {
            return memo[turn][start][end];
        }
        if (turn == 1) {
            // player one trys to maximize his score
            return memo[turn][start][end] = Math.max(
                nums[start] + getPlayerOneScore(nums, start + 1, end, 1 - turn), 
                nums[end] + getPlayerOneScore(nums, start, end - 1, 1 - turn)
                           );
        } else {
            // player two trys to minimize players one score
            return memo[turn][start][end] = Math.min(
                getPlayerOneScore(nums, start + 1, end, 1 - turn), 
                getPlayerOneScore(nums, start, end - 1, 1 - turn)
                           );
        }
    }
}
