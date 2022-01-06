class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0], maxRight = height[height.length - 1];
        int start = 1, end = height.length - 2;
        int ans = 0;
        while (start <= end) {
            if (maxLeft < maxRight) {
                if (maxLeft < height[start]) {
                    maxLeft = height[start];
                } else {
                    ans += maxLeft - height[start];
                }
                start++;
            } else {
                if (maxRight < height[end]) {
                    maxRight = height[end];
                } else {
                
                    ans += maxRight - height[end];
                }
                end--;
            }
        }
        return ans;
    }
}
