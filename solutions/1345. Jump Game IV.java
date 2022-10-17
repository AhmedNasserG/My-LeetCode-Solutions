class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0 ; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList();
        q.add(0);
        visited[0] = true;
        
        int ans = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            while(levelSize-- > 0) {
                int cur = q.remove();
                if (cur == n - 1) return ans;  
                
                for (int next : map.get(arr[cur])) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
                map.get(arr[cur]).clear();
                
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    visited[cur - 1] = true;
                    q.add(cur - 1);
                }
                
                if (cur + 1 < n && !visited[cur + 1]) {
                    visited[cur + 1] = true;
                    q.add(cur + 1);
                }
            }
            ans++;
        }
        return -1;
    }
}
