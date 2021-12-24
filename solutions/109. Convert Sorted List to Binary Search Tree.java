    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        node = head;
        int size = getSize(head);
        return helper(0, size - 1);
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
    
    private TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = helper(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
​
// O(nLog(n))
// class Solution {
    /*public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.next);
        return root;
    }*/
// }
​
