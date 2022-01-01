class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList(), candidates, 0, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> path, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        
        if (target < 0 || start == candidates.length) {
            return;
        }
        
        
        if (candidates[start] <= target) {
            // take
            path.add(candidates[start]);
            helper(res, path, candidates, start + 1, target - candidates[start]);
            // remove and go to the next not duplicated
            path.remove(path.size() - 1);
            while (start < candidates.length - 1 && candidates[start] == candidates[start + 1]) start++;
            helper(res, path, candidates, start + 1, target);
        }
    }
}
