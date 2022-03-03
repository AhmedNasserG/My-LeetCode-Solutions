class Solution {
    public int maxLength(List<String> arr) {
        return dp(0, 0, arr);
    }
    private int dp(int idx, int CharMsk, List<String> arr) {
        if (idx == arr.size()) return 0;
        Integer nextMsk = getBitMsk(arr.get(idx));
        int ans = 0;
        if (nextMsk != null && (CharMsk & nextMsk) == 0) {
            ans = arr.get(idx).length() + dp(idx + 1, CharMsk | nextMsk, arr);
        }
        ans = Math.max(ans, dp(idx + 1, CharMsk, arr));
        return ans;
    }
    
    private Integer getBitMsk(String s) {↔}
}
