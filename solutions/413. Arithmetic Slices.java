class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        ArrayList<Integer> list = new ArrayList();
        int prevDiff = Integer.MAX_VALUE, count = 1, ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff == prevDiff) {
                count++;
            } else {
                prevDiff = diff;
                if (count >= 2) {
                    ans += (count) * (count - 1) / 2;
                }
                count = 1;
            }
        }
        if (count >= 2) {
            ans += (count) * (count - 1) / 2;
        }
​
        return ans;
    }
}
