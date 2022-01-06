/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
​
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
​
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap();
        map.put(head, new Node(head.val));
        
        Node current = head;
        while (current != null) {
            if (current.next != null) {
                map.putIfAbsent(current.next, new Node(current.next.val));
                map.get(current).next = map.get(current.next);
            } 
            if (current.random != null) {
                map.putIfAbsent(current.random, new Node(current.random.val));
                map.get(current).random = map.get(current.random);
            }
            current = current.next;
        }
        return map.get(head);
    }
}
