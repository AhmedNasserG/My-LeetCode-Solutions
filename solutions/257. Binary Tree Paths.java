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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList();
        dfs(root, new ArrayList(), ans);
        return ans;
    }
    
    void dfs(TreeNode node, List<Integer> list, List<String> ans) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num).append("->");
            }
            sb.append(node.val);
            ans.add(sb.toString());
        }
        list.add(node.val);
        dfs(node.left, list, ans);
        dfs(node.right, list, ans);
        list.remove(list.size() - 1);
    }
}
