class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            adj[manager[i]].add(i);
        }
        return dfs(headID, informTime, adj);
    }
    
    private int dfs(int node, int[] informTime, ArrayList<Integer>[] adj) {
        int maxTime = 0;
        for (int next : adj[node]) {
            maxTime = Math.max(maxTime, dfs(next, informTime, adj));
        }
        return maxTime + informTime[node];
    }
    
}
