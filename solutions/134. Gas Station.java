class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i  = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;
        
        int start = 0;
        int sumSoFar = 0;
        for (int i = 0; i < n; i++) {
            sumSoFar += gas[i] - cost[i];
            if (sumSoFar < 0) {
                start = i + 1;
                sumSoFar = 0;
            }
        }
        if (sumSoFar < 0 || start == n) return -1;
        return start;
    }
}
