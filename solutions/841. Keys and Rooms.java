class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visit(rooms, visited, 0);
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    void visit(List<List<Integer>> rooms, boolean[] visited, int idx) {
        if (visited[idx]) return;
        visited[idx] = true;
        for (int next : rooms.get(idx)) {
            visit(rooms, visited, next);
        }
    }
}
