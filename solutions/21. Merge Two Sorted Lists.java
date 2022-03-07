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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode tempHead = new ListNode(-1);
        ListNode current = tempHead;
        while (A != null && B != null) {
            if (A.val < B.val) {
                current.next = A;
                current = A;
                A = A.next;
            } else {
                current.next = B;
                current = B;
                B = B.next;
            }
        }
        if (A != null) {
            current.next = A;
        } 
        if (B != null) {
            current.next = B;
        }
        return tempHead.next;
    }
}
