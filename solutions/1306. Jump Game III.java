class Solution {
    public boolean canReach(int[] arr, int start) {
        int ans = 0;
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.remove();
            if (arr[cur] == 0) return true;
            int next = cur + arr[cur], prev = cur - arr[cur];
            if (next < arr.length && !visited[next]) {
                q.add(next);
                visited[next] = true;
            }
            if (prev >= 0 && !visited[prev]) {
                q.add(prev);
                visited[prev] = true;
            }
        }
        return false;
    }
}
