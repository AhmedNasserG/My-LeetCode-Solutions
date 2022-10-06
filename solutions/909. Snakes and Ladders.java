class Solution {
    public int snakesAndLadders(int[][] board) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(1); visited.add(1);
        int steps = 0, n = board.length;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                int cur = q.remove();
                if (cur == n * n) return steps;
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    if (next > n * n) break;
                    int[] cord = getCord(next, n);
                    int r = cord[0], c = cord[1];
                    if (board[r][c] != -1) {
                        next = board[r][c];
                    }  
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }    
            }
            steps++;
        }
        return -1;
    }
    
    private int[] getCord(int val, int n) {
        val--;
        int r = val / n;
        int c = val % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        r = n - 1 - r;
        return new int[]{r, c};
    }
}
