class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue();
        int day = 0, ans = 0, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }
            while (i < n && day == events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            pq.remove();
            ans++;
            day++;
            while(!pq.isEmpty() && day > pq.peek()) {
                pq.remove();
            }
        }
        return ans;
    }
}
