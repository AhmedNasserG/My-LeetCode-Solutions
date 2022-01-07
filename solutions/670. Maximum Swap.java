class Solution {
    public int maximumSwap(int num) {
        char maxSoFar = 1;
        int maxIdx = -1;
        int a = -1, b = -1;
        char[] arr = Integer.toString(num).toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (maxSoFar < arr[i]) {
                maxSoFar = arr[i];
                maxIdx = i;
            } else if (maxSoFar > arr[i]){
                a = maxIdx;
                b = i;
            }
        }
        if (a == -1) {
            return num;
        }
        swap(arr, a, b);
        return Integer.parseInt(new String(arr));
    }
    
    private void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
​
