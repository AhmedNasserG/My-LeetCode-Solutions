class Solution {
    public int deleteAndEarn(int[] nums) {
        freq = getFreqPairs(nums);
        Arrays.sort(freq, (a, b) -> b.val - a.val);
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(0);
    }
    
    private Pair[] freq;
    private int[] memo;
    
    private Pair[] getFreqPairs(int[] nums) {↔}
    
    private int dp(int i) {
        if (i >= freq.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int di = (i + 1 < freq.length && freq[i + 1].val == freq[i].val - 1) ? 2 : 1;
        int take = freq[i].val * freq[i].count + dp (i + di);
        int leave = dp(i + 1);
        return memo[i] = Math.max(take, leave);
    }
    
    class Pair {
        int val, count;
        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
​
/*
{10, 8, 6, 4, 3, 1}
60
{9, }
*/
