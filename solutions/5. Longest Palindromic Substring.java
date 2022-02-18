class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        char[] arr = s.toCharArray();
        int maxLen = 0, ansB = 0, ansE = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.max(expandPal(arr, i, i), expandPal(arr, i, i + 1));
            if (maxLen < len) {
                ansB = i - (len - 1) / 2;
                ansE = i + len / 2;
                maxLen = len;
            }
        }
        return s.substring(ansB, ansE + 1);
    }
    
    int expandPal(char[] arr, int left, int right) {
        while (0 <= left && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
​
