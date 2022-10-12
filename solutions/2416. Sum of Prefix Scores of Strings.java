class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = trie.getScore(words[i]);
        }
        return ans;
    }
    
    public class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        
        public void add(String s) {
            TrieNode current = root;
            for (char c : s.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
                current.freq++;
            }
        }
        
        public int getScore(String s) {
            int ans = 0;
            TrieNode current = root;
            for (char c : s.toCharArray()) {
                current = current.children[c - 'a'];
                ans += current.freq;
            }
            return ans;
        }
    }
    
    public class TrieNode {
        TrieNode[] children;
        int freq;
        public TrieNode() {
            children = new TrieNode[26];
            freq = 0;
        }
    }
}
