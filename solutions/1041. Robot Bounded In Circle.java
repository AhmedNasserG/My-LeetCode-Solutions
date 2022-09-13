class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] pos = {0, 0};
        int face = 0;
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                pos[0] += moves[face][0];
                pos[1] += moves[face][1];
            } else if (c == 'L') {
                face = (face + 1) % 4;
            } else if (c == 'R') {
                face = (face - 1 + 4) % 4;
            }
        }
        return face != 0 || (pos[0] == 0 && pos[1] == 0);
    }
}
