                head.prev = null;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        
        Node removeFisrt() {
            Node ans = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return ans;
        }
    }
​
    private LinkedList list;
    private HashMap<Integer, Node> map;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.list = new LinkedList();
        this.map = new HashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node temp = map.get(key);
        list.remove(temp);
        list.insertLast(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            list.remove(temp);
            list.insertLast(temp);
            temp.val = value;
            return;
        } 
        if (map.size() == capacity) {
            Node temp = list.removeFisrt();
            map.remove(temp.key);
        }
        Node newNode = new Node(key, value);
        list.insertLast(newNode);
        map.put(key, newNode);
    }
}
​
