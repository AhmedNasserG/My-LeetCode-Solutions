public class Solution {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = buildTree(pid, ppid);
        return bfs(map, kill);
    }
    
    public Map<Integer, List<Integer>> buildTree(List<Integer> pid, List<Integer> ppid) {
        int n = pid.size();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        return map;
    }
    
    public List<Integer> bfs(Map<Integer, List<Integer>> map, int kill) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int current = q.remove();
            ans.add(current);
            List<Integer> children = map.getOrDefault(current, new ArrayList<>());
            for (int child : children) {
                q.add(child);
            }
        }
        return ans;
    }

}
