class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (char c : columnTitle.toCharArray()) {
            ans = ans * 26 + (c - 'A' + 1);
        }
        return ans;
    }
}
