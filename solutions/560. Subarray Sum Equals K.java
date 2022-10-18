class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int sumSoFar = 0, ans = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sumSoFar += nums[i];
            ans += map.getOrDefault(sumSoFar - k, 0);
            map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);
        }
        return ans;
    }
}
