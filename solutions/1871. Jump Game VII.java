class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {minJump, maxJump});
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            if (cur[0] <=  n - 1 && n - 1 <= cur[1]) return true;
            if (cur[1] >= n) continue;
            int[] prev = q.isEmpty() ? null : q.remove();
            for (int i = cur[0]; i <= cur[1]; i++) {
                int[] arr = {i + minJump, i + maxJump};
                if (s.charAt(i) == '1' || arr[1] <= cur[1]) continue;
                if (prev == null || arr[0] > prev[1]) {
                    prev = arr;
                    q.add(arr);
                } else {
                    prev[1] = arr[1];
                }
            }
        }
        return false;
    }
}
