/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
​
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur == null) {
                sb.append("null,");
            } else {
                sb.append(cur.val + ",");
                q.add(cur.left);
                q.add(cur.right);
            }
            
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        return sb.toString();
    }
​
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr.length == 0 || arr[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode parent = q.remove();
            if (!arr[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.add(left);
            }
            i++;
            if (!arr[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
