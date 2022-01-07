class Solution {
    private int[] prefix;
    private int max;
    private Random random;
​
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        max = prefix[prefix.length - 1];
        random = new Random();
    }
    
    public int pickIndex() {
        int rand = random.nextInt(max) + 1;
        return getIdx(rand);
    }
    
    private int getIdx(int val) {
        int start = 0, end = prefix.length - 1, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (prefix[mid] >= val) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
