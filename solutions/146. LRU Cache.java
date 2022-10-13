class LRUCache {
    private DLinkedList list;
    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        list = new DLinkedList();
        map = new HashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        list.remove(node);
        list.add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
            list.add(node);
            node.val = value;
        } else {
            Node node = new Node(key, value);
            list.add(node);
            map.put(key, node);
        }
        if (map.size() > capacity) {
            Node node = list.removeOldest();
            map.remove(node.key);
        }
    }
    
    class DLinkedList {
        Node head, tail;
        DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        
        void add(Node node) {
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }
        
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        Node removeOldest() {
            Node node = head.next;
            if (node == tail) return null;
            remove(node);
            return node;
        }
    }
    
    class Node {
        int key, val;
        Node next, prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        Node() {

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
