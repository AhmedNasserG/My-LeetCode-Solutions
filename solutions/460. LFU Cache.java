class LFUCache {
    private HashMap<Integer, Node> map;
    private HashMap<Integer, DLinkedList> freqMap;
    private int size, minFreq;
​
    public LFUCache(int size) {
        this.map = new HashMap();
        this.freqMap = new HashMap();
        this.size = size;
        this.minFreq = 1;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        incrementFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (this.size == 0) return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            incrementFreq(node);
            node.val = value;
        } else {
            if (map.size() == this.size) {
                Node node = freqMap.get(minFreq).remove();
                map.remove(node.key);
            }
            Node node = new Node(key, value, 1);
            map.put(key, node);
            freqMap.putIfAbsent(1, new DLinkedList());
            freqMap.get(1).add(node);
            minFreq = 1;
        }
    }
​
    private void incrementFreq(Node node) {
        int currentFreq = node.freq, nextFreq = currentFreq + 1;
​
        freqMap.get(currentFreq).remove(node);
        if (freqMap.get(currentFreq).isEmpty()) {
            freqMap.remove(currentFreq);
            if (currentFreq == minFreq) {
                minFreq++;
            }
        }
​
        node.freq = nextFreq;
        freqMap.putIfAbsent(nextFreq, new DLinkedList());
        freqMap.get(nextFreq).add(node);
    }
​
    static class Node {
        int key, val, freq;
        Node next, prev;
        Node() {}
        Node(int key, int val, int freq) {
            this.key = key;
