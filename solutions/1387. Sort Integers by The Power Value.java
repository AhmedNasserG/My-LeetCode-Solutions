class Solution {
    public int getKth(int lo, int hi, int k) {
        memo = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->b[1] == a[1]? b[0] - a[0] : b[1] - a[1]);
        for (int i = lo; i <= hi; i++) {
            pq.add(new int[]{i, dp(i)});
            if (pq.size() > k) {
                pq.remove();
            }
        }
        
        return pq.remove()[0];
    }
    
    
    HashMap<Integer, Integer> memo;
    int dp(int num) {
        if (num == 1) {
            return 0;
        }
        if (memo.containsKey(num)) {
            return memo.get(num);
        }
        if (num % 2 == 0) {
            memo.put(num, 1 + dp(num / 2));
        } else {
             memo.put(num, 1 + dp(3 * num + 1));
        }
        return memo.get(num);
    }
}
