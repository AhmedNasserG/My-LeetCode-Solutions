class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int ans = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            ans += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            ans += costs[i][1];
        }
        return ans;
    }
}
