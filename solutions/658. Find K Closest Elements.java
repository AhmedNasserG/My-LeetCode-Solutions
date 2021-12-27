class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        while (end - start >= k) {
            int left = Math.abs(arr[start] - x);
            int right = Math.abs(arr[end] - x);
            if (left <= right) {
                end--;
            } else {
                start++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
