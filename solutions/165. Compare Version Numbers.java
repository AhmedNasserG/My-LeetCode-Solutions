class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        while (i < arr1.length && i < arr2.length) {
            int a = strToInt(arr1[i]), b = strToInt(arr2[i]);
            i++;
            if (a == b) continue;
            return a - b > 0 ? 1 : -1;
        }
        while (i < arr1.length) {
            int a = strToInt(arr1[i++]);
            if (a > 0) return 1;
        }
        while (i < arr2.length) {
            int b = strToInt(arr2[i++]);
            if (b > 0) return -1;
        }
        return 0;
    }
    
    private int strToInt(String str) {
        int num = 0;
        for (char c : str.toCharArray()) {
            num *= 10;
            num += c - '0';
        }
