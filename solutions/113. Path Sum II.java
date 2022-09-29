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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList(), ans);
        return ans;
    }
    
    void dfs(TreeNode current, int sumSoFar, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (current == null) return;
        
        path.add(current.val);
        sumSoFar += current.val;
        
        if (current.left == null && current.right == null) {
            if (sumSoFar == targetSum) {
                ans.add(new ArrayList(path));
            }
        }
        
        dfs(current.left, sumSoFar, targetSum, path, ans);
        dfs(current.right, sumSoFar, targetSum, path, ans);
        
        path.remove(path.size() - 1);
        sumSoFar -= current.val;
    }
}
