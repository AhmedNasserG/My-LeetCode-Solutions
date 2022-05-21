class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        ans[0] = dq.peekFirst();
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == dq.peekFirst()) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
            ans[i - k + 1] = dq.peekFirst();
        }
        
        return ans;
    }
}
