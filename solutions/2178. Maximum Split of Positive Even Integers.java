class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) return new ArrayList();
        int s = 0, e = (int) 1e5, k = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            long rem = finalSum - sumOfFirstKEvens(mid);
            if (rem > 0 && rem > 2 * mid) {
                s = mid + 1;
                k = mid;
            } else {
                e = mid - 1;
            }
        }
        List<Long> ans = new ArrayList();
        for (int i = 1; i <= k; i++) {
            ans.add(2l * i);
            finalSum -= 2 * i;
        }
        ans.add(finalSum);
        return ans;
    }
    
    long sumOfFirstKEvens(int k) {
        return 1l * k * (k + 1);
    }
}
