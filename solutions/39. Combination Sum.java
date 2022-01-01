class Solution {
    private int[] candidates;
    private List<List<Integer>> ans; 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        ans = new ArrayList<>();
        solve(0, new ArrayList<>(), target);
        return ans;
    }
    
    private void solve(int i, List<Integer> temp, int target) {
        if (i == candidates.length || target <= 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] <= target) {
                temp.add(candidates[j]);
                solve(j, temp, target - candidates[j]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
