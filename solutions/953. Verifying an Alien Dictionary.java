class Solution {
    private int[] charVal;
    
    public boolean isAlienSorted(String[] words, String order) {
        initCharValArray(order);
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
    private void initCharValArray(String order) {
        charVal = new int[26];
        for (int i = 0; i < 26; i++) {
            charVal[order.charAt(i) - 'a'] = i;
        }
    }
    
    private int getCharVal(char c) {
        return charVal[c - 'a'];
    }
    
    private int compare(String a, String b) {
        // +ve -> b before a
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                return getCharVal(a.charAt(i)) - getCharVal(b.charAt(j));
            }
            i++;
            j++;
        }
        if (i < a.length()) return 1;
        if (j < b.length()) return -1;
        return 0;
    }
    
}
