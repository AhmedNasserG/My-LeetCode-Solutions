/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }   
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head, prev = dummy;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current != null && current.val == prev.next.val) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
            
        }
        return dummy.next;
    }
}
