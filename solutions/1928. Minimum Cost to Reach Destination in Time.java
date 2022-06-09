// Dijkstra
​
class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adj[u].add(new int[] {v, t});
            adj[v].add(new int[] {u, t});
        }
        int[] shortestTime = new int[n];
        Arrays.fill(shortestTime, (int) 1e9);
        shortestTime[0] = 0;
        // {v, cost, time}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[2] - b[2];
            return a[1] - b[1];
        });
        pq.add(new int[] {0, passingFees[0], 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0], cost = cur[1], time = cur[2];
            if (u == n - 1) return cost;
            for (int[] nxt : adj[u]) {
                int v = nxt[0], t = nxt[1], c = passingFees[v];
                if (time + t > maxTime) continue;
                if (time + t < shortestTime[v]) {
                    shortestTime[v] = time + t;
                    pq.add(new int[] {v, cost + c, shortestTime[v]});
                }
            }
        }
        return -1;
    }
}

// dp
class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        this.maxTime = maxTime;
        this.passingFees = passingFees;
        int n = passingFees.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adj[u].add(new int[] {v, t});
            adj[v].add(new int[] {u, t});
        }
        memo = new int[n][maxTime + 1];
        for (int a[] : memo) Arrays.fill(a, -1);
        int ans = dp(0 ,0);
        if (ans >= INF) return -1;
        return ans;
    }
    static int maxTime;
    static int INF = (int)1e9;
    static int[] passingFees;
    static ArrayList<int[]>[] adj;
    static int[][] memo;
    int dp(int u, int curTime) {
        if (curTime > maxTime) return INF;
        if (u == passingFees.length - 1) return passingFees[u];
        if (memo[u][curTime] != -1) return memo[u][curTime];
        memo[u][curTime] = INF;
        for (int[] nxt : adj[u]) {
            memo[u][curTime] = Math.min(memo[u][curTime], passingFees[u] + dp(nxt[0], curTime + nxt[1]));
        }
        return memo[u][curTime];
    }
}
