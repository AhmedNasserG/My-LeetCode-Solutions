/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 0, new ArrayList());
    }
    
    private int dfs(TreeNode node, int level ,int order, ArrayList<Integer> list) {
        if (node == null) return 0;
        if (level == list.size()) {
            list.add(order);
        }
        int ans = order - list.get(level) + 1;
        int left = dfs(node.left, level + 1, 2 * order, list);
        int right = dfs(node.right, level + 1, 2 * order + 1, list);
        return Math.max(ans, Math.max(left, right));
    }
}
