class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(hm.containsKey(diff)){
                res[0] = i;
                res[1] = hm.get(diff);
                return res;
            }
            hm.put(nums[i], i);
        }
        return res;
    }
}
