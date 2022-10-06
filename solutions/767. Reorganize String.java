class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[max] < freq[i]) max = i;
        }
        if (freq[max] > (n + 1) / 2) return "";
        char[] ans = new char[n];
        int idx = 0;
        while (freq[max]-- > 0) {
            ans[idx] = (char) (max + 'a');
            idx += 2;
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                if (idx >= n) idx = 1;
                ans[idx] = (char) (i + 'a');
                idx += 2;
            }
        }
        return new String(ans);
    }
}
