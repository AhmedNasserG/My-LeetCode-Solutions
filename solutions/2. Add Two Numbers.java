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
    ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int val = carry;
        ListNode nxt1 = null, nxt2 = null;
        if (l1 != null) {
            val += l1.val;
            nxt1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            nxt2 = l2.next;
        }
        carry = val / 10;
        ListNode result = new ListNode(val % 10);
        result.next = add(nxt1, nxt2, carry);
        return result;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
}
