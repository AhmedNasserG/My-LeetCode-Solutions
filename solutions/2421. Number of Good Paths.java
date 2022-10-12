class Solution {
    class UnionFind {↔}
    
    ArrayList<Integer>[] buildGraph(int[][] edges, int n) {↔}
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        
        ArrayList<Integer>[] adj = buildGraph(edges, n);
        UnionFind uf = new UnionFind(n);
        
        List<Integer> ids = new ArrayList();        
        for (int i = 0; i < n; i++) {
            ids.add(i);
        }
        Collections.sort(ids, (a, b) -> vals[a] - vals[b]);
​
        int ans = 0;
        for (int i = 0; i < ids.size(); i++) {
            int j = i + 1;
            while (j < n && vals[ids.get(i)] == vals[ids.get(j)]) j++;
            
            for (int k = i; k < j; k++) {
                int cur = ids.get(k);
                for (int nbr : adj[cur]) {
                    if (vals[nbr] <= vals[cur]) {
                        uf.union(cur, nbr);
                    }
                }
            }
            
            HashMap<Integer, Integer> temp = new HashMap();
            for (int k = i; k < j; k++) {
                int cur = ids.get(k);
                int group = uf.find(cur);
                temp.put(group, temp.getOrDefault(group, 0) + 1);
            }
            for (int v : temp.values()) {
                ans += v * (v - 1) / 2;
            }
            i = j - 1;
        }
        return ans + n;
    }
}
