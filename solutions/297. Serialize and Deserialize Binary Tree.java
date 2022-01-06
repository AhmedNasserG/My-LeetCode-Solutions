        if (node == null) {
            sb.append("n,");
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
​
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList();
        q.addAll(Arrays.asList(data.split(",")));
        return deserialize(q);
    }
    
    private TreeNode deserialize(Queue<String> q) {
        if (q.isEmpty()) {
            return null;
        }
        String val = q.remove();
        if (val.equals("n")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
}
​
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
