class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        Arrays.sort(courses, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int day = 0;
        for (int[] course : courses) {
            if (day + course[0] <= course[1]) {
                pq.add(course);
                day += course[0];
            } else if (!pq.isEmpty() && course[0] < pq.peek()[0]) {
                int diff = pq.remove()[0] - course[0];
                pq.add(course);
                day -= diff;
            }
        }
        return pq.size();
    }
}
