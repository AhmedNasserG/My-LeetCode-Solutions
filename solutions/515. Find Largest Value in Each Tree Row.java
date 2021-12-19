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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }
    
    void helper(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.val);
        } else {
            list.set(level, Math.max(root.val, list.get(level)));
        }
        helper(root.left, level + 1, list);
        helper(root.right, level + 1, list);
    }
}
