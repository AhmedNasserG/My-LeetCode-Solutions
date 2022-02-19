class Solution {
    public int minimumSum(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        Arrays.sort(arr);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            a.append(arr[i]);
            if (++i < arr.length) {
                b.append(arr[i]);
            }
        }
        return Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());
    }
}
