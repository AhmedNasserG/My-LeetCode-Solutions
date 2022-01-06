class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min == null || min < node.val) && (max == null || node.val < max)) {
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max); 
        }
        return false;
    }
}
