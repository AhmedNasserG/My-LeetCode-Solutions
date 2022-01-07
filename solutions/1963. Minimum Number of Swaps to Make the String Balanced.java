class Solution {
    public int minSwaps(String s) {
        int missmatch = 0, stack = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack++;
            } else {
                stack--;
            }
            if (stack < 0 && c == ']') {
                stack = 0;
                missmatch++;
            }
        }
        return (missmatch + 1) / 2;
    }
}
