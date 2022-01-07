class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int lastPeek = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                lastPeek = i;
            }
        }
        if (lastPeek == -1) {
            return -1;
        }
        int swapWith = lastPeek + 1;
        int j = swapWith;
        while (j < arr.length && arr[j] > arr[lastPeek]) {
            swapWith = j++;
        }
        swap(arr, lastPeek, swapWith);
        reverse(arr, lastPeek + 1, arr.length - 1);
        long ans = Long.parseLong(new String(arr));
        if (ans > Integer.MAX_VALUE) {
            return -1;
        } 
        return (int) ans;
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}
