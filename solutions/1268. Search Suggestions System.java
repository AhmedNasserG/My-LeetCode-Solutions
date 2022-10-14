                current = current.next[c - 'a'];
            }
        }
        
        List<List<String>> search(String s) {
            TrieNode current = root;
            List<List<String>> ans = new ArrayList();
            for (char c : s.toCharArray()) {
                if(current.next[c - 'a'] == null) break;
                current = current.next[c - 'a'];
                List<String> temp = new ArrayList();
                while (!current.pq.isEmpty()) {
                    temp.add(current.pq.remove());
                }
                ans.add(temp);
                Collections.reverse(temp);
            }
            for (int i = ans.size(); i < s.length(); i++) {
                ans.add(new ArrayList());
            }
            return ans;
        }
    }
    
    class TrieNode {
        TrieNode[] next;
        PriorityQueue<String> pq;
        TrieNode() {
            next = new TrieNode[26];
            pq = new PriorityQueue<String>((a, b) -> b.compareTo(a));
        }
        
        void addString(String s) {
            pq.add(s);
            if (pq.size() > 3) pq.remove();
        }
    }
}
