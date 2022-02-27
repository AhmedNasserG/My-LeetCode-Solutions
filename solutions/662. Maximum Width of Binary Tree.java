class Solution {
    HashMap<Integer, Interval> map;
    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap();
        dfs(root, 0, 1);
        int ans = 0;
        for (Interval i : map.values()) {
            ans = Math.max(ans, i.getWidth());
        }
        return ans;
    }
    
    private void dfs(TreeNode node, int level, int order) {
        if (node == null) return;
        map.putIfAbsent(level, new Interval(order));
        map.get(level).updateInterval(order);
        dfs(node.left, level + 1, 2 * order);
        dfs(node.right, level + 1, 2 * order + 1);
    }
    
    class Interval {
        private int start, end;
        Interval(int val) {
            start = val;
            end = val;
        }
        
        void updateInterval(int val) {
            end = val;
        }
        
        int getWidth() {
            return end - start + 1;    
        }
    }
}
