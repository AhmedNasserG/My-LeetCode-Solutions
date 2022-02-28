class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList();
        if (nums.length == 0) return ans;
        Range current = new Range(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (current.canAdd(num)) {
                current.add(num);
            } else {
                ans.add(current.getStr());
                current = new Range(num);
            }
        }
        ans.add(current.getStr());
        return ans;
    }
    
    class Range {
        private int start, end;
        Range(int val) {
            this.start = val;
            this.end = val;
        }
        
        boolean canAdd(int val) {
            return end + 1 == val;
        }
        
        void add(int val) {
            this.end = val;
        }
​
        String getStr() {
