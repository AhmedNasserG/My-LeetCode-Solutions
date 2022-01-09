class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> memo = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    if (!memo.add(current + " is found in row" + i) ||
                            !memo.add(current + " is found in column" + j) ||
                            !memo.add(current + " is found in row" + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
