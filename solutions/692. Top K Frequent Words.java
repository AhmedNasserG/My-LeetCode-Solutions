class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Word> pq = new PriorityQueue();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(new Word(e.getKey(), e.getValue()));
        }
        List<String> ans = new ArrayList();
        for (int i = 0; i < k; i++) {
            ans.add(pq.remove().word);
        }
        return ans;
    }
    
    class Word implements Comparable{
        String word;
        int freq;
        Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
        public int compareTo(Object o) {
            Word w = (Word) o;
            if (this.freq == w.freq) {
                return this.word.compareTo(w.word);
            }
            return w.freq - this.freq;
        }
    }
}
