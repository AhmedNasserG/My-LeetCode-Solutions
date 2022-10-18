/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList();
        List<Integer> ans = new ArrayList();
        HashMap<TreeNode, List<TreeNode>> map = new HashMap();
        buildGraph(null, root, map);
        HashSet<TreeNode> visited = new HashSet();
        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                if (k < 0) return ans;
                TreeNode cur = q.remove();
                if (k == 0) ans.add(cur.val);
                for (TreeNode next : map.get(cur)) {
                    if (visited.contains(next)) continue;
                    q.add(next);
                    visited.add(next);
                }
            }
            k--;
        }
        return ans;
    }
    
    public void buildGraph(TreeNode prev, TreeNode node, HashMap<TreeNode, List<TreeNode>> map) {
        if (node == null) return;
        map.putIfAbsent(node, new ArrayList());
        if (prev != null) map.get(node).add(prev);
        if (node.left != null) map.get(node).add(node.left);
        if (node.right != null) map.get(node).add(node.right);
        buildGraph(node, node.left, map);
        buildGraph(node, node.right, map);
    }
}
