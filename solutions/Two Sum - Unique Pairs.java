class Solution {
    public static int twoSumUniquePairs(List<Integer> nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        for (int num : nums) {
          if (set.contains(target - num)) {
            int[] temp = {num, target - num};
            Arrays.sort(temp);
            ans.add(temp[0] + "," + temp[1]);
          }
          set.add(num);
        }
        return ans.size();
    }
}
