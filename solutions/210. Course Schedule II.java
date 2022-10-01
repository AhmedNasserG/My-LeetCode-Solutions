class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int cur = 0; cur < numCourses; cur++) {
            adj[cur] = new ArrayList();
        }
        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }        
        int[] visited = new int[numCourses]; // 0 -> unvisited, 1 -> visited, 2 -> added to output
        int[] output = new int[numCourses];
        int[] idx = {-1};
        for (int cur = 0; cur < numCourses; cur++) {
            if (!dfs(cur, visited, adj, output, idx)) {
                return new int[0];
            }
        }
        return output;
    }
    
    private boolean dfs(int cur, int[] visited, ArrayList<Integer>[] adj, int[] output, int[] idx) {
        if (visited[cur] == 1) { // cycle detcted
            return false;
        }
        if (visited[cur] == 2) { // already added stop dfs
            return true;
        }
        visited[cur] = 1;
        for (int next : adj[cur]) {
            if (!dfs(next, visited, adj, output, idx)) {
                return false;
            }
        }
        visited[cur] = 2;
        output[++idx[0]] = cur;
        return true;
    }
}
