class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord, endWord, wordList);
    }
    
    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();
        Set<String> wordSet = new HashSet(wordList);
        q.add(beginWord);
        visited.add(beginWord);
        int cost = 1;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                String current = q.remove();
                if (current.equals(endWord)) return cost;
                char[] arr = current.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String next = new String(arr);
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            q.add(next);
                            visited.add(next);
                        }
                    }
                    arr[i] = old;
                }
            }
            cost++;
        }
        return 0;
    }
}
