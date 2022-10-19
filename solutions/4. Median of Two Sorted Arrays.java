class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int x = nums1.length, y = nums2.length;
        int start = 0, end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sizeTakenFromX = mid;
            int sizeTakenFromY = (x + y + 1) / 2 - sizeTakenFromX;
            
            int xLeft = sizeTakenFromX == 0 ? Integer.MIN_VALUE : nums1[sizeTakenFromX - 1];
            int xRight = sizeTakenFromX == nums1.length ? Integer.MAX_VALUE : nums1[sizeTakenFromX];
            
            int yLeft = sizeTakenFromY == 0 ? Integer.MIN_VALUE : nums2[sizeTakenFromY - 1];
            int yRight = sizeTakenFromY == nums2.length ? Integer.MAX_VALUE : nums2[sizeTakenFromY];
            
            if (xLeft <= yRight && yLeft <= xRight) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2.0;
                } else {
                    return Math.max(xLeft, yLeft);
                }
            } else if (xLeft > yRight) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
​
