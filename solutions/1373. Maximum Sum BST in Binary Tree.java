class Solution {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxSum;
    }
    
    private Helper solve(TreeNode root) {
        if (root == null) {
            return null;
        }
        Helper left = solve(root.left);
        Helper right = solve(root.right);
        Helper current = new Helper(root);
        if (left != null) {
            current.min = Math.min(left.min, current.min);
            current.max = Math.max(left.max, current.max);
            current.sum += left.sum;
            current.isBST &= left.isBST && root.val > left.max;
        }
        if (right != null) {
            current.min = Math.min(right.min, current.min);
            current.max = Math.max(right.max, current.max);
            current.sum += right.sum;
            current.isBST &= right.isBST && root.val < right.min;
        }
        if (current.isBST) {
            maxSum = Math.max(maxSum, current.sum);
        }
        return current;
    }
