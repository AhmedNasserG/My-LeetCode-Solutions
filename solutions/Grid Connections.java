class Solution {
    public static int connections(List<List<Integer>> grid) {
        List<Integer> list = new ArrayList<>();
        for (List<Integer> l : grid) {
          int sum = 0;
          for (int node : l) {
            sum += node;
          }
          if (sum > 0) {
            list.add(sum);
          }
        }
        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
          ans += list.get(i) * list.get(i - 1);
        }
        return ans;
    }
}
