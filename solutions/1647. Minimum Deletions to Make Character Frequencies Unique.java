class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int keep = freq[25], prev = freq[25];
        for (int i = 24; i >= 0 && freq[i] != 0 && prev != 0; i--) {
            prev = Math.min(freq[i], prev - 1);
            keep += prev;
        }
        return s.length() - keep;
    }
}
​
