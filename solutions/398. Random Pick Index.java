class Solution {
    
    private HashMap<Integer, List<Integer>> map;
    private Random random;
​
    public Solution(int[] nums) {
        map = new HashMap();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
