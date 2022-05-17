/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
​
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
​
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node nestedHead = flatten(current.child);
                current.child = null;
                current = insertList(current, nestedHead);
            }
            current = current.next;
        }
        
        return head;
    }
    
    private Node insertList(Node current, Node nestedHead) {
        Node nestedTail = getTail(nestedHead);
        
        nestedTail.next = current.next;
        if (current.next != null) {
            current.next.prev = nestedTail;
        }
        
        current.next = nestedHead;
        if (nestedHead != null) {
            nestedHead.prev = current;
        }
        
        return nestedTail;
    }
    
    private Node getTail(Node node) {
        if (node == null) return null;
        while (node.next != null) node = node.next;
        return node;
    }
}
