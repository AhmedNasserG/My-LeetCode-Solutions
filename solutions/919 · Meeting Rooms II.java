public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int ans = 0, cur = 0;
        while (i < n) {
            if (start[i] < end[j]) {
                cur++;
                i++;
            } else {
                cur--;
                j++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
