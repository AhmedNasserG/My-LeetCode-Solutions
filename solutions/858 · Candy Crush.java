
public class Solution {

    public int[][] candyCrush(int[][] board) {
        int R = board.length, C = board[0].length;
        boolean update = true;
        while (update) {
            update = false;
            // scan rows for elements to be deleted
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C - 2; c++) {
                    int num1 = Math.abs(board[r][c]); 
                    int num2 = Math.abs(board[r][c + 1]); 
                    int num3 = Math.abs(board[r][c + 2]);
                    if (num1 == num2 && num1 == num3 && num1 != 0) {
                        board[r][c] = -num1;
                        board[r][c + 1] = -num2;
                        board[r][c + 2] = -num3;
                        update = true;
                    }
                }
            }
            // scan cols for elements to be deleted
            for (int c = 0; c < C; c++) {
                for (int r = 0; r < R - 2; r++) {
                    int num1 = Math.abs(board[r][c]); 
                    int num2 = Math.abs(board[r + 1][c]); 
                    int num3 = Math.abs(board[r + 2][c]); 
                    if (num1 == num2 && num1 == num3 && num1 != 0) {
                        board[r][c] = -num1;
                        board[r + 1][c] = -num2;
                        board[r + 2][c] = -num3;
                        update = true;
                    }
                }
            }
            // update board
            for (int c = 0; c < C; c++) {
                int last = R - 1;
                for (int r = R - 1; r >= 0; r--) {
                    if (board[r][c] == 0) break;
                    if (board[r][c] < 0) continue;
                    board[last--][c] = board[r][c];
                }
                while (last >= 0 && board[last][c] != 0) {
                    board[last--][c] = 0;
                }
            }
        }
        return board;
    }
    
}
