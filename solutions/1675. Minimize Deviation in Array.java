class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) num *= 2;
            pq.add(num);
            min = Math.min(min, num);
        }
        int dev = pq.peek() - min;
        while (pq.peek() % 2 == 0) {
            int num = pq.remove() / 2;
            min = Math.min(min, num);
            pq.add(num);
            dev = Math.min(dev, pq.peek() - min);
        }
        return dev;
    }
}
​
