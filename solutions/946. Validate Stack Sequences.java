class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int topIdx = -1, i = 0, j = 0;
        for (i = 0; i < pushed.length; i++) {
            pushed[++topIdx] = pushed[i];
            while (topIdx >= 0 && pushed[topIdx] == popped[j]) {
                j++;
                topIdx--;
            }
        }
        return j == popped.length;
    }
}
