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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }
    
    private int solve(TreeNode node) {
        if (node == null) return 0;
        
        int left = Math.max(solve(node.left), 0);
        int right = Math.max(solve(node.right), 0);
        
        max = Math.max(max, left + node.val + right);
        
        return node.val + Math.max(left, right);
    }
}
