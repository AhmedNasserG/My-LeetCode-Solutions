class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 1, end = Integer.MAX_VALUE, ans = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValidAns(weights, days, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean isValidAns(int[] weights, int days, int maxWeight) {
        int sum = 0;
        for (int w : weights) {
            if (w > maxWeight) return false;
            if (sum + w > maxWeight) {
                sum = 0;
                days--;
            }
            sum += w;
        }
        return days > 0;
    }
}
