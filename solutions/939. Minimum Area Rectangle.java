class Solution {
    public int minAreaRect(int[][] points) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Set<Integer>> map = new HashMap();
        for (int[] p : points) {
            map.putIfAbsent(p[0], new HashSet());
            map.get(p[0]).add(p[1]);
        }
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                        ans = Math.min(calculateArea(p1, p2), ans);
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        } else {
            return ans;
        }
    }
    
    private int calculateArea(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) * Math.abs(a[1] - b[1]);
    }
    
}
