// Solution with LinkedHashSet, HashSet

public class Solution {
    
    public int firstUniqueNumber(int[] nums, int number) {
        HashSet<Integer> dup = new HashSet<>();
        LinkedHashSet<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) {
            if (dup.contains(num)) continue;
            if (unique.contains(num)) {
                unique.remove(num);
                dup.add(num);
            } else {
                unique.add(num);
            }
            if (num == number) return unique.iterator().next();
        }
        return -1;
    }
  
}

// Solution with Doubly LinkedList, HashMap, HashSet

public class Solution {
    
    public int firstUniqueNumber(int[] nums, int number) {
        HashMap<Integer, Node> unique = new HashMap<>();
        DLinkedList list = new DLinkedList();
        HashSet<Integer> dup = new HashSet<>();
        for (int num : nums) {
            if (dup.contains(num)) continue;
            if (unique.containsKey(num)) {
                list.remove(unique.get(num));
                unique.remove(num);
                dup.add(num);
            } else {
                Node node = new Node(num);
                list.addLast(node);
                unique.putIfAbsent(num, node);
            }
            if (num == number) return list.getFirst();
        }
        return -1;
    }
    
    class Node {
        int val;
        Node prev, next;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    class DLinkedList {
        Node head, tail;
        
        public DLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }
        
        public int getFirst() {
            return head.next.val;
        }
    }
}
