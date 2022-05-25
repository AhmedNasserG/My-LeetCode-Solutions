/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.add(root);
        colQueue.add(0);
        int minCol = 0, maxCol = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.remove();
            int col = colQueue.remove();
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(current.val);
            if (current.left != null) {
                nodeQueue.add(current.left);
                colQueue.add(col - 1);
            }
            if (current.right != null) {
                nodeQueue.add(current.right);
                colQueue.add(col + 1);
            }
        }
        int size = maxCol - minCol + 1;
        List<Integer>[] ans = new List[size];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            ans[entry.getKey() - minCol] = entry.getValue();
        }
        return Arrays.asList(ans);
    }
}
