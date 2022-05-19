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
    private static int maxLevel, ans;
    public int findBottomLeftValue(TreeNode root) {
        maxLevel = 0;
        ans = 0;
        preOrder(root, 0);
        return ans;
    }
    
    private void preOrder(TreeNode node, int level) {
        if (node == null) return;
        if (level == maxLevel) {
            ans = node.val;
            maxLevel++;
        }
        preOrder(node.left, level + 1);
        preOrder(node.right, level + 1);
    }
}
