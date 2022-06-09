class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        buildGraph(n, edges);
        int[] ans = new int[n];
        dfs(0, labels, new boolean[n], ans);
        return ans;
    }
    
    private static ArrayList<Integer>[] adj;
    
    private static void buildGraph(int n, int[][] edges) {↔}
    
    private static int[] dfs(int node, String labels, boolean[] visited, int[] ans) {
        visited[node] = true;
        int[] freq = new int[26];
        for (int next : adj[node]) {
            if (visited[next]) continue;
            merge(freq, dfs(next, labels, visited, ans));
        }
        char c = labels.charAt(node);
        ans[node] = ++freq[c - 'a'];
        return freq;
    }
    
    private static void merge(int[] a, int[] b) {↔}
}
