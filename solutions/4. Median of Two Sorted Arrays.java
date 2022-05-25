class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (m < n) return findMedianSortedArrays(nums2, nums1);
        int start = 0, end = n;
        while (start <= end) {
            int xPos = (start + end) / 2;
            int yPos = (n + m + 1) / 2 - xPos;
            
            int lX = xPos - 1 < 0 ? Integer.MIN_VALUE : nums1[xPos - 1];
            int lY = yPos - 1 < 0 ? Integer.MIN_VALUE : nums2[yPos - 1];
            int rX = xPos < n ? nums1[xPos] : Integer.MAX_VALUE;
            int rY = yPos < m ? nums2[yPos] : Integer.MAX_VALUE;
            
            if (lX <= rY && lY <= rX) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(lX, lY) + Math.min(rX, rY)) / 2.0;
                } else {
                    return Math.max(lX, lY);
                }
            } else if (lX > rY) {
                end = xPos - 1;
            } else {
                start = xPos + 1;
            }
        }
        return -1;
    }
}
​
