/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
​
class Solution {
    private HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map = new HashMap();
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node root) {
        map.putIfAbsent(root, new Node(root.val));
        for (Node neighbor : root.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new Node(neighbor.val));
                map.get(root).neighbors.add(map.get(neighbor));
                dfs(neighbor);
            } else {
                map.get(root).neighbors.add(map.get(neighbor));
            }
        }
    }
}
