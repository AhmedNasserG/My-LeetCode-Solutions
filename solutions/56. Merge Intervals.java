class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> list = new ArrayList();
        int[] lastInterval = new int[2];
        lastInterval[0] = intervals[0][0];
        lastInterval[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intersect(lastInterval, intervals[i])) {
                lastInterval[0] = Math.min(lastInterval[0], intervals[i][0]);
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                list.add(lastInterval.clone());
                lastInterval[0] = intervals[i][0];
                lastInterval[1] = intervals[i][1];
            }
        }
        list.add(lastInterval);
        return list.toArray(new int[0][]);
    }
    
    private boolean intersect(int[] a, int[] b) {
        int start = Math.max(a[0], b[0]);
        int end = Math.min(a[1], b[1]);
        return start <= end;
    }
}
