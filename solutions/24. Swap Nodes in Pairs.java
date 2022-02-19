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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = head, prev = dummy;
        while (current != null && current.next != null) {
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = current;
            prev = current;
            current = current.next;
        }
        return dummy.next;
    }
}
