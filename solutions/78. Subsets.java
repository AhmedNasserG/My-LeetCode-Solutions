class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // sol 1
        // return dp(nums.length, nums);
        
        //sol 2
        List<List<Integer>> ans = new ArrayList();
        powSet(nums, 0, new ArrayList(), ans);
        return ans;
    }
    
    private List<List<Integer>> dp(int size, int[] nums) {
        if (size == 0) {
            List<List<Integer>> ans = new ArrayList();
            ans.add(new ArrayList());
            return ans;
        }
        List<List<Integer>> newAns = new ArrayList();
        List<List<Integer>> prevAns = dp(size - 1, nums);
        for (List<Integer> list : prevAns) {
            newAns.add(new ArrayList(list));
            list.add(nums[size - 1]);
            newAns.add(list);
        }
        return newAns;
        
    }
    
    private void powSet(int[] nums, int i, List<Integer> tmp, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList(tmp));
            return;
        }
        // take
        tmp.add(nums[i]);
        powSet(nums, i + 1, tmp, ans);
        tmp.remove(tmp.size() - 1);
        //leave
        powSet(nums, i + 1, tmp, ans);
    }
}
​
​
