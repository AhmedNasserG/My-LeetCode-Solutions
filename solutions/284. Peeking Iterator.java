class PeekingIterator implements Iterator<Integer> {
    private Integer lastPeeked;
    private Iterator<Integer> iterator;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.lastPeeked = iterator.next();
    }
    
    public Integer peek() {
        return lastPeeked;
    }
​
    @Override
    public Integer next() {
        Integer ans = lastPeeked;
        if (iterator.hasNext()) {
            lastPeeked = iterator.next();
        } else {
            lastPeeked = null;
        }
        return ans;
    }
    
    @Override
    public boolean hasNext() {
        return lastPeeked != null;
    }
}
​
​
