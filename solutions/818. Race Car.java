class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 1});
        HashSet<String> visited = new HashSet();
        int ans = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                int pos = q.peek()[0];
                int speed = q.peek()[1];
                q.remove();
                if (pos == target) {
                    return ans;
                }
                if (visited.contains(pos + "," + speed)) continue;
                visited.add(pos + "," + speed);
                q.add(new int[] {pos + speed, speed * 2});
                if (pos + speed > target && speed > 0 || pos + speed < target && speed < 0) {
                    q.add(new int[] {pos, speed > 0 ? -1 : 1});
                }
            }
            ans++;
        }
        return -1;
    }
}
​
