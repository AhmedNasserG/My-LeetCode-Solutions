class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, l = 0, r = 0;
        while (l < n && r < m) {
            if (nums1[l] < nums2[r]) {
                merged[i++] = nums1[l++];
            } else {
                merged[i++] = nums2[r++];
            }
        }
        while (l < n) {
            merged[i++] = nums1[l++];
        }
        while (r < m) {
            merged[i++] = nums2[r++];
        }
        if ((m + n) % 2 == 0) {
            return (merged[(m + n) / 2] + merged[(m + n) / 2 - 1]) / 2.0;
        } else {
            return merged[(m + n) / 2];
        }
    }
}
