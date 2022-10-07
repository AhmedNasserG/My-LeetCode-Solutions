class Solution {
    List<Integer>[] adj;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0), v = connection.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }
        in = new int[n];
        low = new int[n];
        visited = new boolean[n];
        timer = 0;
        bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }
        return bridges;
    }
    
    int[] in, low;
    boolean[] visited;
    int timer; 
    List<List<Integer>> bridges;
    
    void dfs(int current, int parent) {
        visited[current] = true;
        in[current] = timer; low[current] = timer;
        timer++;
        for (int next : adj[current]) {
            if (next == parent) continue;
            if (!visited[next]) {
                dfs(next, current);
                if (low[next] > in[current]) {
                    bridges.add(Arrays.asList(new Integer[]{current, next}));
                }
            }
            low[current] = Math.min(low[current], low[next]);
        }
    }
}
