class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {nums[i], i};
        }
        int[] result = new int[n];
        mergeSort(arr, 0, n - 1, result);
        List<Integer> ans = new ArrayList();
        for (int val : result) {
            ans.add(val);
        }
        return ans;
    }
    
    void mergeSort(int[][] arr, int start, int end, int[] result) {
        if (start == end) return;
        
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, result);
        mergeSort(arr, mid + 1, end, result);
        
        List<int[]> merged = new ArrayList();
        int i = start, j = mid + 1;
        int movedFromRight = 0;
        while (i <= mid && j <= end) {
            if (arr[i][0] > arr[j][0]) {
                movedFromRight++;
                merged.add(arr[j]);
                j++;
            } else {
                result[arr[i][1]] += movedFromRight;
                merged.add(arr[i]);
                i++;
            }
        }
        while (i <= mid) {
            result[arr[i][1]] += movedFromRight;
            merged.add(arr[i++]);
        }
        while (j <= end) {
            movedFromRight++;
            merged.add(arr[j++]);
        }
        
        
        for (int k = 0; k < merged.size(); k++) {
            arr[start + k] = merged.get(k);
        } 
    }
}
