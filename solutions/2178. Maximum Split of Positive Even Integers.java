class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList();
        if (finalSum % 2 != 0) return ans;
        long i = 2;
        while (finalSum > 0) {
            if (ans.size() == 0 || finalSum >= i) {
                ans.add(i);
                finalSum -= i;
                i += 2;
            } else {
                ans.set(ans.size() - 1, finalSum + ans.get(ans.size() - 1));
                finalSum = 0;
            }
        }
        return ans;
    }
}
