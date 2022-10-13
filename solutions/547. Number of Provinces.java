class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.groups;
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int groups;
        UnionFind(int n) {
            groups = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        int find(int v) {
            if (parent[v] == v) return v;
            return parent[v] = find(parent[v]);
        }
        
        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    parent[a] = b;
                    rank[b] += rank[a];
                } else {
                    parent[b] = a;
                    rank[a] += rank[b];
                }
                groups--;
            }
        }
    }
}
