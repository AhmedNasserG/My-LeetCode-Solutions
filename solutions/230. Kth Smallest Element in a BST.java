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
    private int order = 0; 
    
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k);
    }
    
    private Integer inOrder(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        Integer left = inOrder(root.left, k);
        order++;
        if (left != null) {
            return left;
        }
        if (order == k) {
            return root.val;
        }
        return inOrder(root.right, k);
    }
    
}
