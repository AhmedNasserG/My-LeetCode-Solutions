class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        helper(root, 0, ans);
        return ans;
    }
    
    private void helper(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        } else {
            list.set(level, root.val);
        }
        helper(root.left, level + 1, list);
        helper(root.right, level + 1, list);
    }
}
