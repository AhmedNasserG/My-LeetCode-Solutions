                } else {
                    return this.level - node.level;
                }
            }
            return this.col - node.col;
            
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<ColNode> pq = new PriorityQueue<>();
        dfs(root, pq, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = null;
        int lastCol = Integer.MIN_VALUE;
        
        while (!pq.isEmpty()) {
            ColNode node = pq.remove();
            if (node.col != lastCol) {
                if (temp != null) {
                    ans.add(temp);
                }
                temp =  new ArrayList<>();
                lastCol = node.col;
            }
            temp.add(node.val);
        }
        ans.add(temp);
        return ans;
    }
    
    void dfs(TreeNode root, PriorityQueue<ColNode> pq, int level, int col) {
        if (root == null) {
            return;
        }
        pq.add(new ColNode(root.val, level, col));
        dfs(root.left, pq, level + 1, col - 1);
        dfs(root.right, pq, level + 1, col + 1);
    }
}
