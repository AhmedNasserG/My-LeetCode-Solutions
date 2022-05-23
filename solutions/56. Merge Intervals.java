class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList();
        for (int[] interval : intervals) {
            if (!list.isEmpty()) {
                int[] lastInterval = list.get(list.size() - 1);
                if (lastInterval[1] >= interval[0]) {
                    lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                    continue;
                }
            }
            list.add(interval);
        }
        return list.toArray(new int[0][0]);
    }
}
