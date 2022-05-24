public class Solution 
{
    public static TreeNode<Integer> cloneBinaryTreeRandomPointer(TreeNode<Integer> root)
    {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(null, null);
        return clone(root ,map);
    }
    
    private static TreeNode<Integer> clone(TreeNode<Integer> node, HashMap<TreeNode, TreeNode> map) {
        if (node == null) return null;
        map.putIfAbsent(node, new TreeNode(node.data));
        if (node.random != null) {
            map.putIfAbsent(node.random, new TreeNode(node.random.data));
        }
        map.get(node).random = map.get(node.random);
        
        map.get(node).left = clone(node.left, map);
        map.get(node).right = clone(node.right, map);
        
        return map.get(node);
    }
}
