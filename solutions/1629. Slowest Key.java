class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int res = -1, max = 0, last = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int dur = releaseTimes[i] - last;
            last = releaseTimes[i];
            if (dur > max) {
                max = dur;
                res = i;
            } else if (dur == max) {
                res = keysPressed.charAt(res) < keysPressed.charAt(i) ? i : res;
            }
        }
        return keysPressed.charAt(res);
    }
}
