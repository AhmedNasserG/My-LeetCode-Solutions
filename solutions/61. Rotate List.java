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
    public ListNode rotateRight(ListNode head, int k) {
        int count = count(head);
        if(count == 0){
            return head;
        }
        k = k % count;
        ListNode current = head, prev = null;
        while(current.next != null){
            if(--count == k){
                prev = current;
            }
            current = current.next;
        }
        if(prev != null){
        current.next = head;
        head = prev.next;
        prev.next = null;}
        return head;
        
    }
    
    int count (ListNode head){
        ListNode current = head;
        int res = 0;
        while(current != null){
            res++;
            current = current.next;
        }
        return res;
    }
}
