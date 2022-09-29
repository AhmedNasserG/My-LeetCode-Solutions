class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Item> pq = new PriorityQueue();
        dfs(root, 0, 0, pq);
        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Item item = pq.remove();
            if (item.col != prevCol) {
                prevCol = item.col;
                ans.add(new ArrayList());
            }
            ans.get(ans.size() - 1).add(item.val);
        }
        return ans;
    }
    
    void dfs(TreeNode node, int row, int col, PriorityQueue<Item> pq) {
        if (node == null) return;
        pq.add(new Item(node.val, row, col));
        dfs(node.left, row + 1, col - 1, pq);
        dfs(node.right, row + 1, col + 1, pq);
    }
    
    class Item implements Comparable<Item>{
        int val, row, col;
        Item(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
        
        public int compareTo(Item item) {
            if (this.row == item.row && this.col == item.col) {
                return this.val - item.val;
            }
            if (this.col == item.col) {
                return this.row - item.row;
            }
                
            return this.col - item.col;
        }
    }
}
