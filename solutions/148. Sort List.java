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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode rightHead = split(head);
        head = mergeSort(head);
        rightHead = mergeSort(rightHead);
        return merge(head, rightHead);
    }
    
    private ListNode split(ListNode slow) {
        if (slow == null || slow.next == null) return null;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } 
        fast = slow.next;
        slow.next = null;
        return fast;
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode ans = new ListNode();
        ListNode current = ans;
        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        if (a != null) {
            current.next = a;
        } else {
            current.next = b;
        }
        return ans.next;
    }
}
