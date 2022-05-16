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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    private String dfs(TreeNode node, String str) {
        if (node == null) {
            return str;
        }
        String newStr = (char)('a' + node.val) + str;
        if (node.left == null) return dfs(node.right, newStr);
        if (node.right == null) return dfs(node.left, newStr);
        String left = dfs(node.left, newStr);
        String right = dfs(node.right, newStr);
        if (left.compareTo(right) < 0) {
            return left;
        } else {
            return right;
        }
    }
}
