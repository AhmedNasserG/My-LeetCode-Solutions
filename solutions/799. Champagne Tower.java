class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] PT = new double[query_row + 1][];
        PT[0] = new double[]{poured};
        for (int r = 0; r < query_row; r++) {
            PT[r + 1] = new double[r + 2];
            for (int c = 0; c <= r; c++) {
                double newPoured = (PT[r][c] - 1) / 2.0;
                if (newPoured > 0) {
                    PT[r + 1][c] += newPoured;
                    PT[r + 1][c + 1] += newPoured;
                }
            }
        }
        return Math.min(1, PT[query_row][query_glass]);
    }
}
