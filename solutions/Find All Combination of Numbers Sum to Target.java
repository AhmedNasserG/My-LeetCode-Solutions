class Solution{
    static ArrayList<ArrayList<Integer>> print_all_sum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        solve(0, target, 1, new ArrayList<>(), output);
        return output;
    }

    static void solve(int sum, int target, int start, ArrayList<Integer> prevAns, ArrayList<ArrayList<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(prevAns));
        }
        for (int i = start; i <= target - sum; i++) {
            prevAns.add(i);
            solve(sum + i, target, i, prevAns, ans);
            prevAns.remove(prevAns.size() - 1);
        }
    }
}
