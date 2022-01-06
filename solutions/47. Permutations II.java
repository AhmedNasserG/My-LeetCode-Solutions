class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        permute(nums, 0, new ArrayList(), ans);
        return ans;
    }
    
    private void permute(int[] nums, int msk, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && (msk & (1 << (i - 1))) == 0) {
                continue;
            }
            if ((msk & (1 << i)) == 0) {
                temp.add(nums[i]);
                permute(nums, msk | (1 << i), temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
}
