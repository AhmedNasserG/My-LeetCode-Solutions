class Solution {
    public int maxStudents(char[][] s) {
        seats = s;
        R = seats.length;
        C = seats[0].length;
        memo = new int[R * C][1 << C][1 << C];
        for (int[][] a : memo) for(int[] b : a) Arrays.fill(b, -1);
        return dp(0, 0, 0);
    }
   
    
    private static char[][] seats;
    private static int R, C;
    private static int[][][] memo;
    private static int dp(int pos, int curRow, int prevRow) {
        if (pos == R * C) {
            return 0;
        }
        if (memo[pos][curRow][prevRow] != -1) {
            return memo[pos][curRow][prevRow];
        }
        int r = pos / C, c = pos % C;
        if (c == 0) {
            prevRow = curRow;
            curRow = 0;
        }
        int ans = 0;
        // leave
        ans = Math.max(ans, dp(pos + 1, curRow, prevRow));
        // take
        if ((c == 0 || getBit(curRow, c - 1) == 0) // left student check
                && (c == 0 || getBit(prevRow, c - 1) == 0) // left-down student check
                && (c == C - 1 || getBit(prevRow, c + 1) == 0) // right-down student check
                && seats[r][c] == '.') { // not broken seat check
            ans = Math.max(ans, 1 + dp(pos + 1, setBit(curRow, c), prevRow));
        }
        return memo[pos][curRow][prevRow] = ans;
    }
​
    private static int setBit(int msk, int i) {
        return msk | (1 << i);
    }
​
    private static int getBit(int msk, int i) {
        return (msk & (1 << i)) == 0 ? 0 : 1;
    }
​
}
