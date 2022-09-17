class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] ans = new int[nums.length];
        int[] ones = new int[32];
        
        int start = nums.length - 1, end = nums.length - 1;
        
        while (start >= 0) {
            add(ones, nums[start]);
            while (start != end && canRemove(ones, nums[end])) {
                remove(ones, nums[end]);
                end--;
            }
            ans[start] = end - start + 1;
            start--;
        }
        return ans;
    }
    
    boolean canRemove(int[] ones, int num) {
        for (int i = 0; i < 32; i++) {
            if (isSet(num, i) && ones[i] < 2) {
                return false;
            }
        }
        return true;
    }
    
    void add(int[] ones, int num) {
        for (int i = 0; i < 32; i++) {
            if (isSet(num, i)) {
               ones[i]++;
            }
        }
    }
    
    void remove(int[] ones, int num) {
        for (int i = 0; i < 32; i++) {
            if (isSet(num, i)) {
               ones[i]--;
            }
        }
    }
    
