class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int cur = 0; cur < numCourses; cur++) {
            adj[cur] = new ArrayList();
        }
        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }        
        boolean[] visited = new boolean[numCourses];
        for (int cur = 0; cur < numCourses; cur++) {
            if (!dfs(cur, visited, adj)) {
                return false;
            }
        }
        return true;
    }
    
    boolean dfs(int cur, boolean[] visited, ArrayList<Integer>[] adj) {
        if (visited[cur]) {
            return false;
        }
        if (adj[cur].size() == 0) {
            return true;
        }
        visited[cur] = true;
        for (int next : adj[cur]) {
            if (!dfs(next, visited, adj)) {
                return false;
            }
        }
        visited[cur] = false;
        adj[cur].clear();
        return true;
    }
}
