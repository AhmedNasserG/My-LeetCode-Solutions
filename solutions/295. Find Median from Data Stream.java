class MedianFinder {
    private PriorityQueue<Integer> left, right;
​
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.size() != right.size()) {
            right.add(num);
            left.add(right.remove());
        } else {
            left.add(num);
            right.add(left.remove());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (right.peek() + left.peek()) / 2.0;
        } else {
            return right.peek();
        }
    }
}
​
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
