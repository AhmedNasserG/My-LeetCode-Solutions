class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int start = 0, end = arr.length - 1, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans = mid;
            }
        }
        
        start = 0;
        end = arr[0].length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[ans][mid] == target) {
                return true;
            } else if (arr[ans][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;    
    }
}
